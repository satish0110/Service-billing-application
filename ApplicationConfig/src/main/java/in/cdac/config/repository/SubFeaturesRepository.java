package in.cdac.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.config.model.SubFeatures;

public interface SubFeaturesRepository extends JpaRepository<SubFeatures, Long> {
    
}
