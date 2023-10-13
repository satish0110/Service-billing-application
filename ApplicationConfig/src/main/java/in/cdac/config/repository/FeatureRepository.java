package in.cdac.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.config.model.Feature;
import jakarta.transaction.Transactional;

@Transactional
public interface FeatureRepository extends JpaRepository<Feature, Long>{

    
    
}
