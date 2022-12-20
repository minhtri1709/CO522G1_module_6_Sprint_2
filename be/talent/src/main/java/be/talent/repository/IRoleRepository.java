package be.talent.repository;

import be.talent.model.Role;
import be.talent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role where is_delete = 0 and name like %:username%", nativeQuery = true)
    Role findByUsername(String username);
}
