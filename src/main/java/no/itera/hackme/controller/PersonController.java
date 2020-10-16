package no.itera.hackme.controller;

import no.itera.hackme.dto.Person;
import no.itera.hackme.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final UserRepository userRepository;

    public PersonController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<Person> findAll() {
        return userRepository.filterByName("");
    }

    @GetMapping("/{name}")
    public List<Person> findByName(@PathVariable String name) {
        return userRepository.filterByName(name);
    }
}
