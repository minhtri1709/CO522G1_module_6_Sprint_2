package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean isDelete;
    private String birthday;
    private Integer gender;
    private String idCard;
    private String email;
    private String address;
    private String phoneNumber;


    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    public Customer(Integer id, String name, boolean isDelete, String birthday, Integer gender, String idCard,
                    String email, String address, String phoneNumber, User user) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Customer() {
    }
}
