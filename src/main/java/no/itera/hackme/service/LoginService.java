package no.itera.hackme.service;

import no.itera.hackme.dto.User;
import no.itera.hackme.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User performLogin(String username, String password) {
        var userCandidate = userRepository.fetchUserByUsername(username);

        if (userCandidate.isPresent() && BCrypt.checkpw(password, userCandidate.get().getPasswordHash())) {
            return userCandidate.get();
        }

        throw new UsernameNotFoundException("Username " + username + " not found in database");
    }

}
