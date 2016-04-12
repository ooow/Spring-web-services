package Model;

import javax.persistence.*;

/**
 * Created by Гога on 11.04.2016.
 */


@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "login"))
public class User extends Model {
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Position post;

    public User() {
        super();
    }

    public User(Long id) {
        super(id);
    }

    public User(String login, String password, String name, String surname, Role role, Position post) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.post = post;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Position getPost() {
        return post;
    }

    public void setPost(Position post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "login: " + login + "\n" +
                "password: " + password + "\n" +
                "name: " + name + "\n" +
                "surname: " + surname + "\n" +
                "role:\n" + role.toString() + "\n" +
                "post:\n" + post.toString();
    }
}
