package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer talentId;
    private String name;
    private String price;

    private String talentDescription;

    private Integer discount;

    private String image;
    private boolean isDelete;

    @ManyToOne
    @JoinColumn(name = "talent_type_id", referencedColumnName = "id")
    private TalentType talentType;

    public Talent() {
    }

    public Talent(Integer talentId, String name, String price, String talentDescription, Integer discount,
                  String image, boolean isDelete, TalentType talentType) {
        this.talentId = talentId;
        this.name = name;
        this.price = price;
        this.talentDescription = talentDescription;
        this.discount = discount;
        this.image = image;
        this.isDelete = isDelete;
        this.talentType = talentType;
    }
}
