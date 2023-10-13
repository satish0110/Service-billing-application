package in.cdac.config.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.config.Services.SubFeaturesService;
import in.cdac.config.model.Feature;
import in.cdac.config.model.SubFeatures;
@RestController
public class SubFeaturesController {
    @Autowired
    private SubFeaturesService subFeaturesService;

    @GetMapping("/subfeatures")
    public List<SubFeatures> getSubFeatures(){
        return this.subFeaturesService.getSubFeatures();
    }
    @PostMapping("/subfeatures")
    public SubFeatures addSubFeatures(@RequestBody SubFeatures subFeatures){
        return this.subFeaturesService.addSubFeatures(subFeatures);
    }

    @PostMapping("/subfeature/map")
    public Feature mapFeatureToSubFeatures(@RequestParam Long featureId, @RequestParam Long subFeatureId) {
        return subFeaturesService.mapFeatureToSubFeatures(featureId, subFeatureId );
    }
    @GetMapping("/subfeatures/{subFeatureId}")
    public SubFeatures getSubFeatures(@PathVariable String subFeatureId){
        return this.subFeaturesService.getSubFeaturesById(Long.parseLong(subFeatureId));
    }

    @DeleteMapping("/subfeatures/{subFeatureId}")
    public ResponseEntity<HttpStatus> deletesubFeatures(@PathVariable String subFeatureId){
        try{
            this.subFeaturesService.deletesubFeatures(Long.parseLong(subFeatureId));
            return new ResponseEntity<>(HttpStatus.OK);
          }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
}
