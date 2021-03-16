package br.com.wallet.dto;

import javax.validation.constraints.Email;

import lombok.Data;

// DTO = Data Transfer Object

@Data

public class UserDTO {

	private Long id;

	@Email(message = "E-mail inválido")
	private String email;

	private String name;

	private String password;

}
