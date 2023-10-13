package in.cdac.config.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.config.model.UserFeatureId;
import in.cdac.config.model.UserFeatures;
import jakarta.transaction.Transactional;

@Transactional
public interface UserFeatureRepository extends JpaRepository<UserFeatures, UserFeatureId>{

   

}
