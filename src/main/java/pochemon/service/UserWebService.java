package pochemon.service;

import org.springframework.stereotype.Service;
import pochemon.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserWebService {
    public UserDTO getUser(Integer id) {
        return new UserDTO();
    }

    public Boolean editUser(UserDTO userDto) {
        return true;
    }

    public Boolean removeUser(UserDTO userDto) {
        return true;
    }

    public Boolean addUser(UserDTO userDto) {
        return true;
    }

    public Boolean authentication(String username, String password) {
        return true;
    }

    public List<UserDTO> getAllUsers() {
        return new ArrayList<>();
    }
}
