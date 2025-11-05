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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.nose.business.facade.impl.UserFacadeImpl;
import co.edu.uco.nose.controller.dto.Response;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.dto.UserDto;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	
	@PostMapping
	public  ResponseEntity<Response<UserDto>> registerNewUserInformation (@RequestBody UserDto user) {
		
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var facade = new UserFacadeImpl();
		facade.registerNewUserInformation(user);
		responseObjectData.addMessage(MessagesEnum.USER_SUCESSFULLY_REGISTERED.getContent());
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
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
		responseObjectData.addMessage(MessagesEnum.USER_SUCESSFULLY_UPDATED.getContent());
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
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
		responseObjectData.addMessage(MessagesEnum.USER_SUCESSFULLY_DELETED.getContent());
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
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
		responseObjectData.addMessage(MessagesEnum.USER_SUCESSFULLY_FOUND.getContent());
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}

	@GetMapping
	public ResponseEntity<Response<UserDto>> findUserByFilter (
			@RequestParam(name = "identification-number", required = false) String identificationNumber,
			@RequestParam(name = "first-name", required = false) String firstName,
			@RequestParam(name = "middle-name", required = false) String middleName,
			@RequestParam(name = "last-name", required = false) String lastName,
			@RequestParam(name = "second-last-name", required = false) String secondLastname,
			@RequestParam(name = "email", required = false) String email,
			@RequestParam(name = "phone-number", required = false) String cellPhoneNumber,
			@RequestParam(name = "email-confirmed", required = false) boolean emailConfirmed,
			@RequestParam(name = "phone-number-confirmed", required = false) boolean phoneNumberConfirmed){
		
		
		Response<UserDto> responseObjectData = Response.createSuccededResponse();
		HttpStatusCode responseStatusCode = HttpStatus.OK;
		
	try {
		var userFilters = new UserDto();
		userFilters.setIdentificationNumber(identificationNumber);
		userFilters.setFirstName(firstName);
		userFilters.setMiddleName(middleName);
		userFilters.setLastName(lastName);
		userFilters.setSecondLastName(secondLastname);
		userFilters.setEmail(email);
		userFilters.setCellPhoneNumber(cellPhoneNumber);
		userFilters.setEmailConfirmed(emailConfirmed);
		userFilters.setCellPhoneNumberConfirmed(phoneNumberConfirmed);
		
		var facade = new UserFacadeImpl();
		responseObjectData.setData(facade.findUserByFilter(userFilters));
		responseObjectData.addMessage(MessagesEnum.USER_SUCESSFULLY_FOUND.getContent());
		
		
	} catch (final NoseException exception) {
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(exception.getUserMessage());
		responseStatusCode = HttpStatus.BAD_REQUEST;
		exception.printStackTrace();
	} catch( Exception exception) {
		var userMessage = MessagesEnum.USER_ERROR_TRYING_TO_MAKE_AN_OPERATION.getContent();
		responseObjectData = Response.createFailedResponse();
		responseObjectData.addMessage(userMessage);
		responseStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		exception.printStackTrace();
	}
		
		return new ResponseEntity<>(responseObjectData, responseStatusCode);
		
	}
	

}
