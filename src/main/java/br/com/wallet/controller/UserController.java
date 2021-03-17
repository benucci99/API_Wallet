package br.com.wallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wallet.dto.UserDTO;
import br.com.wallet.entity.User;
import br.com.wallet.response.Response;
import br.com.wallet.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<Response<UserDTO>> create(@Validated @RequestBody UserDTO dto, BindingResult result) {

		Response<UserDTO> response = new Response<UserDTO>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(e -> response.getErrors().add(e.getDefaultMessage()));	
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			
		}

		User user = service.save(this.convertDtoToEntity(dto));
		
		response.setData(this.convertEntityToDto(user));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}
	
	private User convertDtoToEntity(UserDTO dto) {
		User u = new User();
		u.setId(dto.getId());
		u.setEmail(dto.getEmail());
		u.setName(dto.getName());
		u.setPassword(dto.getPassword());
		
		return u;
		
		
	}
	
	private UserDTO convertEntityToDto(User u) {
		UserDTO dto = new UserDTO();
		dto.setId(u.getId());
		dto.setEmail(u.getEmail());
		dto.setName(u.getName());
		dto.setPassword(u.getPassword());
		
		return dto;
	}

}
