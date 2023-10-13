package in.cdac.config.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import in.cdac.config.model.Feature;

// import org.springframework.beans.factory.annotation.Autowired;

import in.cdac.config.model.SubFeatures;
// import in.cdac.config.repository.SubFeaturesRepository;

public interface SubFeaturesService {
    public List<SubFeatures> getSubFeatures();
    public SubFeatures addSubFeatures(SubFeatures subFeatures);
    public Feature mapFeatureToSubFeatures(@RequestParam Long featureId, @RequestParam Long subFeatureId);
    public SubFeatures getSubFeaturesById(@PathVariable Long subFeatureId);
    public void deletesubFeatures(Long parseLong);

}
