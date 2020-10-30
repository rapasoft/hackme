package no.itera.hackme;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

class HackMeApplicationTests {

    // Not really a test, this is just for educational purposes
    @Test
    void generatePasswordHash() {
        System.out.println(BCrypt.hashpw("P4SSW0RD", BCrypt.gensalt()));
        System.out.println(BCrypt.hashpw("bigdaddy100", BCrypt.gensalt()));
        System.out.println(BCrypt.hashpw("swordfish", BCrypt.gensalt()));
    }

}
