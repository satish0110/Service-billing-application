package in.cdac.config.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.cdac.config.model.UserFeatures;

@Service
public interface UserFeatureServices {    
    public UserFeatures addUserFeatures(UserFeatures userFeatures);
    public List<UserFeatures> getAllUserFeatures();
    public UserFeatures updateUserFeatures(Long userId, UserFeatures userFeatures);
    // public List<UserFeatures> getUserFeaturesByUserId(Long userId);
}
