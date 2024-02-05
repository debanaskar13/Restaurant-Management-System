package com.example.first.microservice;

import com.example.first.microservice.dto.RoleDto;
import com.example.first.microservice.model.Role;
import com.example.first.microservice.repository.RoleRepository;
import com.example.first.microservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class FirstMicroserviceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstMicroserviceApplication.class, args);

		RoleRepository roleRepo = context.getBean(RoleRepository.class);

		Optional<Role> admin = roleRepo.findByTitle("ADMIN");
		Optional<Role> user = roleRepo.findByTitle("USER");

		if(admin.isEmpty() && user.isEmpty()){
			roleRepo.save(Role.builder().title("ADMIN").description("Administrative Access").slug("admin,administration").active(true).build());
			roleRepo.save(Role.builder().title("USER").description("User Access").slug("user,customer").active(true).build());
		}
	}

}
