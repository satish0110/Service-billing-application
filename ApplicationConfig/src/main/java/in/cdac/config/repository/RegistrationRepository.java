package in.cdac.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.config.model.Registration;
import jakarta.transaction.Transactional;

@Transactional
public interface RegistrationRepository extends JpaRepository<Registration, Long>{
    
}
