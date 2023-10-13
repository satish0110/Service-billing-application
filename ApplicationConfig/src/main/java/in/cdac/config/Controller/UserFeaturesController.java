package in.cdac.config.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.config.Services.FeaturesServices;
import in.cdac.config.Services.UserFeatureServices;
import in.cdac.config.Services.UserServices;
import in.cdac.config.model.Feature;
import in.cdac.config.model.User;
import in.cdac.config.model.UserFeatures;

@RestController
@RequestMapping("/userfeatures")
public class UserFeaturesController {
    @Autowired
    private UserFeatureServices userFeatureService;
    @Autowired
    private UserServices userService;
    @Autowired
    private FeaturesServices featureService;
    
    @GetMapping
    public List<UserFeatures> getAllUserFeatures() {
        return userFeatureService.getAllUserFeatures();
    }

    // @PostMapping("/{userId}/{featureId}/activated")
    // public ResponseEntity<String> createdUserFeaturesWithStatus(@PathVariable Long userId, 
    //                                                             @PathVariable Long featureId, 
    //                                                             @RequestBody Boolean activated,
    //                                                             @PathVariable String role) {
    //     User user = userService.getUserByuserId(userId);
    //     Feature feature = featureService.getFeaturesById(featureId);
      
    //     if (user != null && feature != null){            
    //         UserFeatures userFeatures = new UserFeatures();
    //         userFeatures.setUser(user);
    //         userFeatures.setFeature(feature);
    //         userFeatures.isActivated(activated);
    //         userFeatures.setRole(role);
    //         // userFeatures.setCreatedDate(new Date());                      

    //         userFeatureService.addUserFeatures(userFeatures);

    //         return ResponseEntity.ok().body("Success");

    //     } else {
    //         return ResponseEntity.badRequest().body(null);
    //     }
             
    // }
    @PostMapping("/{userId}/{featureId}/activated")
    public ResponseEntity<String> createdUserFeaturesWithStatus(
        @PathVariable Long userId,
        @PathVariable Long featureId,
        @RequestBody UserFeatures userFeature) {
    
    User user = userService.getUserByuserId(userId);
    Feature feature = featureService.getFeaturesById(featureId);
  
    if (user != null && feature != null) {
        UserFeatures userFeatures = new UserFeatures();
        userFeatures.setUser(user);
        userFeatures.setFeature(feature);
        userFeatures.setActivated(userFeature.isActivated());
        // userFeatures.setRole(userFeature.getRole()); // Use the role from the request

        userFeatureService.addUserFeatures(userFeatures);

        return ResponseEntity.ok().body("{\"message\": \"Success\"}");
    } else {
        return ResponseEntity.badRequest().body(null);
    }
}

    
}
