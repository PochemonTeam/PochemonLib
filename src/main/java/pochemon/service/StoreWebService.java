package pochemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pochemon.dto.CardDTO;
import pochemon.dto.StoreOrderDTO;
import pochemon.dto.StoreTransactionDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreWebService {

    @Value("${store.service.uri}")
    private String storeServiceUrl;

    private final RestTemplate restTemplate;

    public StoreWebService() {
        this.restTemplate = new RestTemplate();
    }

    public Boolean sellCard(StoreOrderDTO storeOrderDTO) {
        String url = storeServiceUrl + "/store/sell";

        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, storeOrderDTO, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public boolean buyCard(StoreOrderDTO storeOrderDTO) {
        String url = storeServiceUrl + "/store/buy";

        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, storeOrderDTO, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public List<StoreTransactionDTO> getAllTransactions() {
        String url = storeServiceUrl + "/store/transaction/all";

        ResponseEntity<List<StoreTransactionDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<StoreTransactionDTO>>() {});
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Gérer le cas d'erreur si nécessaire
            return new ArrayList<>();
        }
    }

    public List<StoreOrderDTO> getAllOrders() {
        String url = storeServiceUrl + "/store/order/all";

        ResponseEntity<List<StoreOrderDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<StoreOrderDTO>>() {});
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Gérer le cas d'erreur si nécessaire
            return new ArrayList<>();
        }
    }
}
