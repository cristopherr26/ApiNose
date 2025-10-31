package co.edu.uco.nose.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.dto.UserDto;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@GetMapping
	public ResponseEntity<Response<UserDto>> findAllUsers () {
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		responseObjectData.setData(facade.findAllUsers());
		responseObjectData.addMessage("All users filtered succesfully");
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@PostMapping
	public  ResponseEntity<Response<UserDto>> registerNewUserInformation (@RequestBody UserDto user) {
		
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		facade.registerNewUserInformation(user);
		responseObjectData.addMessage(" User registered sucesfully");
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<UserDto>> updateUserInformation (@PathVariable UUID id, @RequestBody UserDto user) {
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		facade.updateUserInformation(id, user);
		responseObjectData.addMessage(" User updated sucesfully");
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<UserDto>> dropUserInformation (@PathVariable UUID id) {
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		facade.dropUserInformation(id);
		responseObjectData.addMessage(" User deleted sucesfully");
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<UserDto>> findUserById (@PathVariable UUID id) {
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		responseObjectData.setData(List.of(facade.findUserById(id)));
		responseObjectData.addMessage("User filtered succesfully");
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	
	@PostMapping("/{filter}")
	public ResponseEntity<Response<UserDto>> findUserByFilter (@RequestBody UserDto userFilters) {
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		responseObjectData.setData(facade.findUserByFilter(userFilters));
		responseObjectData.addMessage("Users filtered succesfully");
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = "Unexpected error";
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	

}
