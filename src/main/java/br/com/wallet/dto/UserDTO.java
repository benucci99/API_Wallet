package br.com.wallet.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

// DTO = Data Transfer Object

@Data

public class UserDTO {

	private Long id;

	@Email(message = "E-mail inválido")
	private String email;

	@Min(3)
	@Max(50)
	private String name;

	@NotNull
	@Min(6)
	private String password;

}
