package com.example.demodtoonetomany;

import com.example.demodtoonetomany.entity.Location;
import com.example.demodtoonetomany.entity.User;
import com.example.demodtoonetomany.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemodtoonetomanyApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testUserLocation(){
		User user = new User();
		user.setFirstName("abc");
		user.setLastName("abc");
		user.setEmail("dsad@gmail.com");
		user.setPassword("sadasda");

		Location l1 = new Location();
		l1.setState("bihar");
		l1.setCity("muz");
		l1.setCountry("india");

		Location l2 = new Location();
		l2.setState("bihar");
		l2.setCity("muz");
		l2.setCountry("india");

		user.getLocations().add(l1);
		user.getLocations().add(l2);
		userRepository.save(user);

	}

}
