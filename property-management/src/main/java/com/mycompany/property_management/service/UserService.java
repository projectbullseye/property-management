package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.UserDTO;

public interface UserService {
    public UserDTO registerUser(UserDTO userDTO);
    public void login(String email, String password);
}
