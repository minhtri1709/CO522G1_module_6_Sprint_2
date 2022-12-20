package be.talent.repository;

import be.talent.dto.ITalentDto;
import be.talent.model.Talent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITalentRepository extends JpaRepository<Talent, Integer> {

    @Query(value = "select talent.id as id, talent.name as name, talent.price as price, talent.discount as discount," +
            " talent.talent_description as talent_description, talent.image as image, talent_type.name as type from talent " +
            "join talent_type on talent_type.id = talent.talent_type_id where talent.is_delete = 0 and talent.name like %:nameS%",
            countQuery = "select count(*)"
                    , nativeQuery = true
    )
    Page<ITalentDto> showListTalent(@Param("nameS")String nameS, Pageable pageable);
}
