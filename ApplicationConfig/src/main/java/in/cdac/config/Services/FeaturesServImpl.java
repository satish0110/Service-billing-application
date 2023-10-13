package in.cdac.config.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.config.model.Feature;
import in.cdac.config.repository.FeatureRepository;
@Service
public class FeaturesServImpl implements FeaturesServices {
    
    @Autowired
    private FeatureRepository featuresRepository;

    
  
    @Override
    public List<Feature> getFeatures() {
            return featuresRepository.findAll();
        }

    @Override
    public Feature addFeatures(Feature features) {
        featuresRepository.save(features);
        return features;   
    }

    @Override
    public Feature getFeaturesById(Long featureId) {
        Optional<Feature> optionalfeatures = featuresRepository.findById(featureId);
        if(optionalfeatures.isPresent()){
            return optionalfeatures.get();
        }
        return null;
    }

    @Override
    public Feature updateFeatures(Feature features) {
        featuresRepository.save(features);
        return features;
    }

    @Override
    public void deleteFeatures(Long parseLong) {
        featuresRepository.deleteById(parseLong);
    }

    
    


}
