package hrms.hrms.dataAccess.abstracts;

import hrms.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
