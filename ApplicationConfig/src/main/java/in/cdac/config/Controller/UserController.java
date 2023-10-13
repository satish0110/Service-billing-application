package in.cdac.config.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import in.cdac.config.Services.UserFeatureServices;
import in.cdac.config.Services.UserServices;
import in.cdac.config.model.Feature;
import in.cdac.config.model.User;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
   

    @GetMapping("/user")
    public List<User> getUser(){
            return this.userServices.getUser();
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return this.userServices.addUser(user);
    }
    // @PutMapping("/user")
    // public User updateUser(@RequestBody User user){
    //     return this.userServices.updateUser(user);
    // }
    @DeleteMapping("/user/{userid}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userid){
        try{
            this.userServices.deleteUser(Long.parseLong(userid));
            return new ResponseEntity<>(HttpStatus.OK);
          }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable String userId){
        return this.userServices.getUserByuserId(Long.parseLong(userId));
    }

    @GetMapping("/{userId}/enabled-features")
    public ResponseEntity<List<Feature>> getEnabledFeatureNamesByUserId(@PathVariable Long userId) {
        List<Feature> enabledFeatureNames = userServices.getEnabledFeatureNamesByUserId(userId);
    
        if (!enabledFeatureNames.isEmpty()) {
            return ResponseEntity.ok(enabledFeatureNames);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    
    
}