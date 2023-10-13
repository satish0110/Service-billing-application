package in.cdac.config.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.config.model.Feature;
import in.cdac.config.model.User;
import in.cdac.config.model.UserFeatures;
import in.cdac.config.repository.UserRepository;


@Service
public class UserServImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
  
    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Long parseLong) {
        userRepository.deleteById(parseLong);
    }

    @Override
    public User getUserByuserId(Long userId) {
        Optional<User> optionaluser = userRepository.findById(userId);
            if(optionaluser.isPresent()){
            return optionaluser.get();
        }
         return null;   
    }

    //  @Override
    // public List<UserFeatures> getEnabledFeaturesByuserId(Long userId) {
    //     List<UserFeatures> enabledFeatures = new ArrayList<UserFeatures>();
    //     Optional<User> optionaluser = userRepository.findById(userId);
    //         if(optionaluser.isPresent()){
    //          for(UserFeatures uf: optionaluser.get().getUserFeatures())   {
    //             if(uf.isActivated()){
    //                 enabledFeatures.add(uf.getFeature().getName());
    //             }
    //          }

    //         return enabledFeatures;
    //     }
    //      return null;   
    // }

//     @Override
// public List<String> getEnabledFeatureNamesByUserId(Long userId) {
//     List<String> enabledFeatureNames = new ArrayList<>();

//     Optional<User> optionalUser = userRepository.findById(userId);
//     if (optionalUser.isPresent()) {
//         for (UserFeatures uf : optionalUser.get().getUserFeatures()) {
//             if (uf.isActivated()) {
//                 Feature featureDTO = new Feature();
//                 featureDTO.setName(uf.getFeature().getName());
//                 featureDTO.setUrl(uf.getFeature().getUrl());
//                 enabledFeatureNames.add(featureDTO);
//                 // enabledFeatureNames.add(uf.getFeature().getName()); // Assuming there's a method to get the feature name
//                 // enabledFeatureNames.add(uf.getFeature().getUrl());

//             }
//         }
//     }

//     return enabledFeatureNames;
// }
@Override
public List<Feature> getEnabledFeatureNamesByUserId(Long userId) {
    List<Feature> enabledFeatures = new ArrayList<>(); // Change the type to List<Feature>

    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
        for (UserFeatures uf : optionalUser.get().getUserFeatures()) {
            if (uf.isActivated()) {
                enabledFeatures.add(uf.getFeature()); // Add the Feature object directly
            }
        }
    }

    return enabledFeatures;
}


    

}