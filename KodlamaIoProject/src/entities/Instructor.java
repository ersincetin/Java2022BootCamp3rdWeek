package entities;

public class Instructor {
    private int id;
    private String username;
    private String name;
    private String lastname;
    private String specialty;

    public Instructor() {
    }

    public Instructor(int id, String username, String name, String lastname, String specialty) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
