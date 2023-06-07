package pochemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pochemon.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserWebService {
    private String apiUrl = "http://card-service:8080/api";

    private final RestTemplate restTemplate;

    public UserWebService() {
        this.restTemplate = new RestTemplate();
    }

    public UserDTO getUser(Integer id) {
        String url = apiUrl + "/users/" + id;

        ResponseEntity<UserDTO> responseEntity = restTemplate.getForEntity(url, UserDTO.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Gérer le cas d'erreur si nécessaire
            return new UserDTO();
        }
    }

    public Boolean editUser(UserDTO userDto) {
        String url = apiUrl + "/users";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDto, headers);

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public Boolean removeUser(UserDTO userDto) {
        String url = apiUrl + "/users";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDto, headers);

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public Boolean addUser(UserDTO userDto) {
        String url = apiUrl + "/users";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDto, headers);

        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public Boolean changeMoney(UserDTO user, Float money) {
        String url = apiUrl + "/users/change-money?userId=" + user.getId() + "&money=" + money;

        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, null, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public Boolean authentication(String username, String password) {
        String url = apiUrl + "/users/auth";

        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, null, Boolean.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }

    public List<UserDTO> getAllUsers() {
        String url = apiUrl + "/users";

        ResponseEntity<List<UserDTO>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<UserDTO>>() {});
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            // Gérer le cas d'erreur si nécessaire
            return new ArrayList<>();
        }
    }
}
