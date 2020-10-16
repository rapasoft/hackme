package no.itera.hackme.repository;

import no.itera.hackme.dto.Person;
import no.itera.hackme.dto.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> fetchUserByUsername(String username) {
        var results = jdbcTemplate.query("" +
                        "SELECT U.*, R.NAME as ROLE_NAME, R.LEVEL FROM USER U " +
                        "JOIN USER_ROLE UR ON U.ID = UR.USER_ID " +
                        "JOIN ROLE R ON R.ID = UR.ROLE_ID " +
                        "WHERE username = :username",
                Map.of("username", username),
                (resultSet, i) -> new User(
                        resultSet.getLong("ID"),
                        resultSet.getLong("PERSON_ID"),
                        resultSet.getString("USERNAME"),
                        resultSet.getString("PASSWORD_HASH"),
                        resultSet.getString("ROLE_NAME"),
                        resultSet.getInt("LEVEL")
                ));

        if (results.size() == 1) {
            return Optional.of(results.get(0));
        }

        return Optional.empty();
    }

    public List<Person> filterByName(String name) {
        return jdbcTemplate.query("" +
                "SELECT " +
                "P.NAME as PERSON_NAME, P.AGE, D.NAME AS DEPARTMENT_NAME, ET.NAME AS EMPLOYMENT_TYPE_NAME," +
                " E.START_DATE, E.END_DATE " +
                "FROM PERSON P " +
                "JOIN EMPLOYEE E ON P.ID = E.PERSON_ID " +
                "JOIN DEPARTMENT D ON E.DEPARTMENT_ID = D.ID " +
                "JOIN EMPLOYMENT_TYPE ET ON ET.ID = E.EMPLOYMENT_TYPE_ID " +
                "WHERE P.NAME LIKE '%" + name + "%'", (resultSet, i) -> new Person(
                resultSet.getString("PERSON_NAME"),
                resultSet.getInt("AGE"),
                resultSet.getString("DEPARTMENT_NAME"),
                resultSet.getString("EMPLOYMENT_TYPE_NAME"),
                resultSet.getString("START_DATE"),
                resultSet.getString("END_DATE")
        ));
    }
}
