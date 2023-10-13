package in.cdac.config.model;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "user_feature_map")
@AssociationOverrides({
        @AssociationOverride(name = "userFeatureId.user", joinColumns = @JoinColumn(name = "USER_ID")),
        @AssociationOverride(name = "userFeatureId.feature", joinColumns = @JoinColumn(name = "FEATURE_ID")) })
public class UserFeatures {
    
    @EmbeddedId
    private UserFeatureId userFeatureId = new UserFeatureId();

    private boolean activated;
    // @Column(name = "CREATED_DATE")
    // private Date createdDate;

    public UserFeatureId getUserFeatureId() {
        return userFeatureId;
    }

    public void setUserFeatureId(UserFeatureId userFeatureId) {
        this.userFeatureId = userFeatureId;
    }

    @Transient
    public User getUser() {
        return getUserFeatureId().getUser();
    }

    public void setUser(User user) {
        getUserFeatureId().setUser(user);
    }

    @Transient
    public Feature getFeature() {
        return getUserFeatureId().getFeature();
    }

    public void setFeature(Feature feature) {
        getUserFeatureId().setFeature(feature);
    }

    public boolean isActivated(boolean b) {
        return true;
    }   
}
