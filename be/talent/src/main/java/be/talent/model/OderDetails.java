package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String datePayment;
    private Integer quantity;
    private boolean isDelete;
    private boolean isPay;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public OderDetails() {
    }

    public OderDetails(Integer id, String datePayment, Integer quantity, boolean isDelete, boolean isPay,
                       Customer customer) {
        this.id = id;
        this.datePayment = datePayment;
        this.quantity = quantity;
        this.isDelete = isDelete;
        this.isPay = isPay;
        this.customer = customer;
    }
}
