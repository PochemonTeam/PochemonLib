package pochemon.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import pochemon.dto.AuthDTO;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Setter
@Component
public class AuthWebService {

    private String apiUrl;

    private final RestTemplate restTemplate;

    public AuthWebService() {
        this.restTemplate = new RestTemplate();
        this.apiUrl = System.getenv("API_URL");
    }

    public String login(String username, String password) {
        String url = "http://auth-service:8080/api/auth/login";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        AuthDTO authDTO = new AuthDTO(username, password);
        
        HttpEntity<AuthDTO> requestEntity = new HttpEntity<>(authDTO, headers);

        return restTemplate.postForObject(url, requestEntity, String.class);
    }

    public void register(String username, String password) throws URISyntaxException {
        String url = "http://auth-service:8080/api/auth/register";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        AuthDTO authDTO = new AuthDTO(username, password);
        
        HttpEntity<AuthDTO> requestEntity = new HttpEntity<>(authDTO, headers);
        log.info("Register for url = " + url);
        restTemplate.postForObject(new URI(url), requestEntity, String.class);
    }
}
