package com.loteia.sorteio.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioInput {
	
	@NotNull
	@Email
	private String email;

}
