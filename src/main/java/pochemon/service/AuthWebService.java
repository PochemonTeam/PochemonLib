package pochemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

        return restTemplate.postForObject(url, null, String.class);
    }

    public String register(String username, String password) {
        String url = apiUrl + "/auth/register";

        return restTemplate.postForObject(url, null, String.class);
    }
}
