package no.itera.hackme;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class HackMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackMeApplication.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-ifNotExists", "-tcpAllowOthers", "-tcpPort", "9090"
        );
    }

}
