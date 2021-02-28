package net.codinghub.restservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codinghub.restservice.response.RestResponse;

@RestController
@RequestMapping("/rest-service")
public class CustomRestController {

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> getData() {
		RestResponse response = new RestResponse();
		response.setId(Long.valueOf(1));
		response.setContent("Coding Hub");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
