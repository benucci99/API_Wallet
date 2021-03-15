package br.com.wallet.response;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {
	
	private T data;
	private List<String> errors;
	
	
	
	
	

}
