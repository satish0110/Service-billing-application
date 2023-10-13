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

import in.cdac.config.Services.FeaturesServices;
import in.cdac.config.model.Feature;

@RestController
public class FeatureController {
    @Autowired
    private FeaturesServices featuresServices;

    @GetMapping("/feature")
    public List<Feature> getFeatures(){
        return this.featuresServices.getFeatures();
    }

    @PostMapping("/feature")
    public Feature addFeatures(@RequestBody Feature features){
        return this.featuresServices.addFeatures(features);
    }
    @GetMapping("/feature/{featureId}")
    public Feature getFeatures(@PathVariable String featureId){
        return this.featuresServices.getFeaturesById(Long.parseLong(featureId));
    }
    // @PutMapping("/feature")
    // public Feature updateFeatures(@RequestBody Feature features){
    //     return this.featuresServices.updateFeatures(features);
    // }
    @DeleteMapping("/feature/{featureId}")
    public ResponseEntity<HttpStatus> deleteFeatures(@PathVariable String featureId){
        try{
            this.featuresServices.deleteFeatures(Long.parseLong(featureId));
            return new ResponseEntity<>(HttpStatus.OK);
          }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }

    

    
}
