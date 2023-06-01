package pochemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Setter;
import pochemon.dto.AuthDTO;

@Setter
@Component
public class AuthWebService {

    @Value("${api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public AuthWebService() {
        this.restTemplate = new RestTemplate();
    }

    public String login(String username, String password) {
        String url = apiUrl + "/auth/login";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        AuthDTO authDTO = new AuthDTO(username, password);
        
        HttpEntity<AuthDTO> requestEntity = new HttpEntity<>(authDTO, headers);

        return restTemplate.postForObject(url, requestEntity, String.class);
    }

    public void register(String username, String password) {
        String url = apiUrl + "/auth/register";
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        AuthDTO authDTO = new AuthDTO(username, password);
        
        HttpEntity<AuthDTO> requestEntity = new HttpEntity<>(authDTO, headers);

        restTemplate.postForObject(url, requestEntity, String.class);
    }
}
