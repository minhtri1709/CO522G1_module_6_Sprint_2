package be.talent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TalentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameType;
    private boolean isDelete;

    public TalentType(Integer id, String nameType, boolean isDelete) {
        this.id = id;
        this.nameType = nameType;
        this.isDelete = isDelete;
    }

    public TalentType() {
    }
}
