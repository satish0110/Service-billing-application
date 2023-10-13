package in.cdac.config.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "FEATURES")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "FEATURE_ID")
    private long id;
    private String name;
    private String url;
 
    //bidirectional mapping with userfeatures    
    @JsonIgnore
    @OneToMany(mappedBy = "userFeatureId.feature",  cascade = CascadeType.ALL) 
    private List<UserFeatures> userFeatures;       

    @OneToMany
    @JoinColumn(name="feature_id")
    private List<SubFeatures> subFeatures;

    
}
