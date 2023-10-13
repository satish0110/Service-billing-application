package in.cdac.config.Services;

import java.util.List;

import in.cdac.config.model.Feature;
import in.cdac.config.model.User;

public interface UserServices {
    public List<User> getUser();
    public User addUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long parseLong);
    public User getUserByuserId(Long userId);
    // public List<UserFeatures> getEnabledFeaturesByuserId(Long userId);
    public List<Feature> getEnabledFeatureNamesByUserId(Long userId);
    
}
