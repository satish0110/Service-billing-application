package in.cdac.config.Services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.config.model.UserFeatures;
import in.cdac.config.repository.UserFeatureRepository;

@Service
public class UserFeatureServImpl implements UserFeatureServices {
    @Autowired
    private UserFeatureRepository userFeatureRepository;

    @Override
    public List<UserFeatures> getAllUserFeatures(){
        return userFeatureRepository.findAll();
    }

    @Override
    public UserFeatures addUserFeatures(UserFeatures userfeatures) {
        userFeatureRepository.save(userfeatures);
        return userfeatures;
    }
     @Override
    public UserFeatures updateUserFeatures(Long id, UserFeatures userFeatures) {
        userFeatureRepository.save(userFeatures);
        return userFeatures;
    }
        
    // @Override
    // public List<UserFeatures> getUserFeaturesByUserId(Long userId) {

    //     Feature feture = new Feature();
    //     feture.setId(userId);

    //     UserFeatureId ufi = new UserFeatureId();
    //     ufi.setFeature(feture);

    //     Optional<UserFeatures> userFeatures = userFeatureRepository.findById(null);

    //     // Check if the userFeatureMaps is null or empty before proceeding
    //     if (userFeatures == null || userFeatures.isEmpty()) {
    //         return new ArrayList<>(); // Return an empty list if the userFeatureMaps is null or empty
    //     }

    //     List<UserFeatures> enabledFeatures = new ArrayList<>();

    //     for (UserFeatures userFeature : userFeatures) {
    //         if (userFeature.isActivated()) {
    //             enabledFeatures.add(userFeatures);
    //         }
    //     }

    //     return enabledFeatures;
    // }

    // @Override
    // public List<UserFeatures> getUserFeaturesByUserId(Long userId) {
    //     List<UserFeatures> enabledFeatures = new ArrayList<>();

    //     List<UserFeatures> userFeaturesList = userFeatureRepository.findByUserFeatureIdUserId(userId);

    //     for (UserFeatures userFeature : userFeaturesList) {
    //         if (userFeature.isActivated()) {
    //             enabledFeatures.add(userFeature);//(userFeature.getFeature());
    //         }
    //     }

    //     return enabledFeatures;
    // }


}

