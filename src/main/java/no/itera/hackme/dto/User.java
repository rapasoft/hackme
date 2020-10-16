package no.itera.hackme.dto;

public class User {

    private Long id;
    private Long personId;
    private String username;
    private String passwordHash;
    private String role;
    private int level;

    public User(Long id, Long personId, String username, String passwordHash, String role, int level) {
        this.id = id;
        this.personId = personId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
