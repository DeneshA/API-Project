package co.pragra.coop.springbootjpaproject.entities;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="USER_TBL")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id should not be null or empty")
    private String id;
    @NotNull(message = "Login should not be empty or null")
    @Column(length = 50)
    private String login;

    @NotNull(message = "Password should not be empty or null")
    @Size(min = 8,max = 16,message = "Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;

    @NotNull(message = "First Name should not be empty or null")
    @Column(length = 50,unique = false)
    private String firstName;

    @NotNull(message = "Last Name should not be empty or null")
    @Column(length = 50,unique = false)
    private String lastName;

    @NotNull(message = "E-Mail should not be empty or null")
    @Email
    private String email;

    private boolean activated;


    @Enumerated(EnumType.STRING)
    private String langKey;

    @NotNull(message = "Authories should not be empty or null")
    @Column(length = 50,unique = false)
    private String authorities;


    public User() {
    }

    public User(String id, String login, String password, String firstName, String lastName, String email, boolean activated, String langKey, String authorities) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.langKey = langKey;
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}
