package com.hospital.Service;

import com.hospital.Entity.User;
import com.hospital.Exception.AuthenticationException;
import com.hospital.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private User loggedInUser;

    public void authenticate(String username, String password) throws AuthenticationException {
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid username or password");
        }
        loggedInUser = user;
    }

    public void logout() throws AuthenticationException {
        if (loggedInUser == null) {
            throw new AuthenticationException("No user logged in");
        }
        loggedInUser = null;
    }
}
