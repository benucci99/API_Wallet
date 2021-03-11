package br.com.wallet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3546473296245223420L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String password;	
	@Column(nullable = false)
	private String name;	
	@Column(nullable = false)
	private String email;
	
	
	
	

}
