package be.talent.repository;

import be.talent.dto.ICartDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ICartRepository extends JpaRepository<ICartDto, Integer> {

    @Query(value = "select ")

}
