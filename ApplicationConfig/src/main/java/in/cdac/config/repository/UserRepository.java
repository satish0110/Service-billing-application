package in.cdac.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.cdac.config.model.User;
import jakarta.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{

    
}
