package in.cdac.config.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.config.Services.RegistrationServices;
import in.cdac.config.model.Registration;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationServices registrationService;

    // @CrossOrigin("http://localhost:4200/")
    @GetMapping("/register")
    public List<Registration> getRegistration(){
    	return this.registrationService.getRegistration();
    }
    @PostMapping("/register")
    public Registration addRegistration(@RequestBody Registration registration){
        return this.registrationService.addRegistration(registration);
    }
}
