package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    private String username;
    private String password;
    private boolean isDelete;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(String username, String password, boolean isDelete, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.isDelete = isDelete;
        this.roles = roles;
    }

    public User() {
    }
}
