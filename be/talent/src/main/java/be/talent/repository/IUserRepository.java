package be.talent.repository;

import be.talent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where is_delete = 0 and username like %:username%", nativeQuery = true)
    User findByUsername(String username);
}
