package be.talent.repository;

import be.talent.model.TalentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITalentTypeRepository extends JpaRepository<TalentType, Integer> {
}
