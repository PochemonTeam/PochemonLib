package pochemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pochemon.dto.CardDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardWebService {

    @Value("${api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public CardWebService() {
        this.restTemplate = new RestTemplate();
    }

    public CardDTO getCard(Integer id) {
        String url = apiUrl + "/cards/" + id;

        ResponseEntity<CardDTO> responseEntity = restTemplate.getForEntity(url, CardDTO.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Gérer le cas d'erreur si nécessaire
            return null;
        }
    }

    public Boolean editCard(CardDTO cardDto) {
        String url = apiUrl + "/cards";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CardDTO> requestEntity = new HttpEntity<>(cardDto, headers);

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public Boolean removeCard(Integer id) {

        String url = apiUrl + "/cards/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<CardDTO> getEntity = restTemplate.getForEntity(url, CardDTO.class);
        HttpEntity<CardDTO> requestEntity;

        if (getEntity.getStatusCode().is2xxSuccessful()) {
            requestEntity = new HttpEntity<>(getEntity.getBody(), headers);
        } else {
            // Gérer le cas d'erreur si nécessaire
            return null;
        }

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public List<CardDTO> getAllCardsToSell() {
        String url = apiUrl + "/cards/shop";

        return getCardDTOS(url);
    }

    private List<CardDTO> getCardDTOS(String url) {
        ResponseEntity<List<CardDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CardDTO>>() {});
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Gérer le cas d'erreur si nécessaire
            return new ArrayList<>();
        }
    }

    public List<CardDTO> getAllCards() {
        String url = apiUrl + "/cards";

        return getCardDTOS(url);
    }

    public List<CardDTO> getAllCardsByUser(Integer id) {
        String url = apiUrl + "/cards/user/" + id;

        return getCardDTOS(url);
    }
}
