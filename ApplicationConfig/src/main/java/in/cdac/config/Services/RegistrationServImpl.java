package in.cdac.config.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.config.model.Registration;
import in.cdac.config.repository.RegistrationRepository;

@Service
public class RegistrationServImpl implements RegistrationServices {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> getRegistration() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration addRegistration(Registration registration) {
        registrationRepository.save(registration);
        return registration;
    }
    
}
