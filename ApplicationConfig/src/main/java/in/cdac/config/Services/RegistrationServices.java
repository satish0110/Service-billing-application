package in.cdac.config.Services;

import java.util.List;

import in.cdac.config.model.Registration;

public interface RegistrationServices {
    public List<Registration> getRegistration();
    public Registration addRegistration(Registration registration);

}
