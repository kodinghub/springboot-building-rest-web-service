package net.codinghub.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codinghub.restservice.model.User;
import net.codinghub.restservice.repository.UserRepository;
import net.codinghub.restservice.request.UserRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> users = userRepository.findAll();

		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addNewUser(@RequestBody UserRequest request) {

		User model = new User();
		model.setName(request.getName());
		model.setEmail(request.getEmail());

		User newUser = userRepository.save(model);

		return new ResponseEntity<User>(newUser, HttpStatus.OK);
	}
}
