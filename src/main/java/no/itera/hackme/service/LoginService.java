package no.itera.hackme.service;

import no.itera.hackme.dto.User;
import no.itera.hackme.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User performLogin(String username, String password) {
        var userCandidate = userRepository.fetchUserByUsername(username);

        if (userCandidate.isPresent() && createHash(password).equalsIgnoreCase(userCandidate.get().getPasswordHash())) {
            return userCandidate.get();
        }

        throw new UsernameNotFoundException("Username " + username + " not found in database");
    }

    private String createHash(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
