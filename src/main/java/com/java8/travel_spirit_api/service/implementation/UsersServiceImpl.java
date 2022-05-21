package com.java8.travel_spirit_api.service.implementation;

import com.java8.travel_spirit_api.dto.UsersDTO;
import com.java8.travel_spirit_api.entity.Users;
import com.java8.travel_spirit_api.repository.UsersRepository;
import com.java8.travel_spirit_api.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    protected UsersRepository usersRepository;

    private UsersDTO mapUsersToDTO(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setName(users.getName());
        usersDTO.setSurname(users.getSurname());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setPhone(users.getPhone());
        usersDTO.setUsername(users.getUsername());
        usersDTO.setPassword(users.getPassword());
        return usersDTO;
    }

    private Users mapDTOToUsers(UsersDTO usersDTO) {
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setName(usersDTO.getName());
        users.setSurname(usersDTO.getSurname());
        users.setEmail(usersDTO.getEmail());
        users.setPhone(usersDTO.getPhone());
        users.setUsername(usersDTO.getUsername());
        users.setPassword(usersDTO.getPassword());
        return users;
    }
}
