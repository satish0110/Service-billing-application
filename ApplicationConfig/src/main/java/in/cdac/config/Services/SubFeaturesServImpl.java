package in.cdac.config.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import in.cdac.config.model.Feature;
import in.cdac.config.model.SubFeatures;
import in.cdac.config.repository.FeatureRepository;
import in.cdac.config.repository.SubFeaturesRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SubFeaturesServImpl implements SubFeaturesService {
    @Autowired
    private SubFeaturesRepository subFeaturesRepository;

    @Autowired
    private FeatureRepository featuresRepository;  
    

    @Override
    public List<SubFeatures> getSubFeatures(){
        return subFeaturesRepository.findAll();
    }

    @Override
    public SubFeatures addSubFeatures(SubFeatures subFeatures) {
        subFeaturesRepository.save(subFeatures);
        return subFeatures;
    }

public Feature mapFeatureToSubFeatures(@RequestParam Long featureId, @RequestParam Long subFeatureId) {
    Optional<Feature> featureOptional = featuresRepository.findById(featureId);
    Optional<SubFeatures> subFeaturesOptional = subFeaturesRepository.findById(subFeatureId);

    if (subFeaturesOptional.isPresent() && featureOptional.isPresent()) {
        Feature feature = featureOptional.get();
        SubFeatures subFeature = subFeaturesOptional.get();

        subFeature.setFeature(feature);
        subFeaturesRepository.save(subFeature);
        return feature;
    } else {
        // Handle case where feature or subFeature is not found
        throw new EntityNotFoundException("Error");
    }
}

@Override
public SubFeatures getSubFeaturesById(Long subFeatureId) {
    Optional<SubFeatures> optionalsubfeatures =subFeaturesRepository.findById(subFeatureId);
        if(optionalsubfeatures.isPresent()){
            return optionalsubfeatures.get();
        }
        return null;
}

@Override
public void deletesubFeatures(Long parseLong) {
    subFeaturesRepository.deleteById(parseLong);
}



}
