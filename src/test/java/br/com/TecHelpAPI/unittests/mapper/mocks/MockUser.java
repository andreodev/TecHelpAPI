package br.com.TecHelpAPI.unittests.mapper.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.TecHelpAPI.data.dto.UserDTO;
import br.com.TecHelpAPI.model.User;

public class MockUser {


    public User mockEntity() {
        return mockEntity(0);
    }

    public UserDTO mockDTO() {
        return mockDTO(0);
    }

    public List<User> mockEntityList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockEntity(i));
        }
        return users;
    }

    public List<UserDTO> mockDTOList() {
        List<UserDTO> users = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            users.add(mockDTO(i));
        }
        return users;
    }

    public User mockEntity(Integer number) {
        User user = new User();
        user.setIdUser(number.longValue());
        user.setNameUser("User Name Test" + number);
        user.setPassword("User Password Test" + number);
        user.setDept("User Dept Test" + number);
        user.setEmail("User Email Test" + number);
        return user;
    }

    public UserDTO mockDTO(Integer number) {
        UserDTO user = new UserDTO();
        user.setIdUser(number.longValue());
        user.setNameUser("User Name Test" + number);
        user.setPassword("User Password Test" + number);
        user.setDept("User Dept Test" + number);
        user.setEmail("User Email Test" + number);
        return user;
    }

}