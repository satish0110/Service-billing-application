package in.cdac.config.Services;

import java.util.List;

import in.cdac.config.model.Feature;

public interface FeaturesServices {
    public List<Feature> getFeatures();
    public Feature addFeatures(Feature features);
    public Feature getFeaturesById(Long featureId);
    public Feature updateFeatures(Feature features);
    public void deleteFeatures(Long parseLong);
}
