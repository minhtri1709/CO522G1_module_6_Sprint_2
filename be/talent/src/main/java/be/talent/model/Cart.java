package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    private int id;

    private boolean isDelete;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Talent talent;

    public Cart(int id, boolean isDelete, int quantity, Talent talent) {
        this.id = id;
        this.isDelete = isDelete;
        this.quantity = quantity;
        this.talent = talent;
    }

    public Cart() {
    }
}
