package in.cdac.config.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class UserFeatureId implements Serializable{
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Feature feature;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    
}
