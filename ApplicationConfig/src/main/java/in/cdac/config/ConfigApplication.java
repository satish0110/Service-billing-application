package in.cdac.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ConfigApplication{
 
	// @Autowired 
	// private final UserRepository userRepo;
	// @Autowired
	// private final FeatureRepository featureRepo;  
	// @Autowired
	// private final UserFeatureRepository userFeatureRepo;

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
		
	}
	

	// @Override
	// public void run(String... args) {
	// 	// User u = new User();
	// 	// u.setUsername("rajinikant");
	// 	// u.setPassword("123456");
	// 	// u.setEmail("rajinikant@yopmail.com");
	// 	// userRepo.save(u);

	// 	// Feature f = new Feature();
	// 	// f.setName("Contact us");
	// 	// featureRepo.save(f);
	// 	// Feature f2 = new Feature();
	// 	// f2.setName("Home");
	// 	// featureRepo.save(f2);

	// 	User u1 = userRepo.findById(1l).get();
	// 	Feature f1 = featureRepo.findById(1l).get();
	// 	Feature f2 = featureRepo.findById(2l).get();


	// 	System.out.println("========= " + u1.toString());
	// 	// // System.out.println("========= "+f1);

	// 	// UserFeatures uf = new UserFeatures();
	// 	// uf.setUser(u1);
	// 	// uf.setFeature(f1);

	// 	// uf.setActivated(true);
	// 	// uf.setCreatedDate(new Date());

	// 	// userFeatureRepo.save(uf);

	// 	// uf = new UserFeatures();
	// 	// uf.setUser(u1);
	// 	// uf.setFeature(f2);

	// 	// uf.setActivated(true);
	// 	// uf.setCreatedDate(new Date());
	// 	// userFeatureRepo.save(uf);

	// }
}
