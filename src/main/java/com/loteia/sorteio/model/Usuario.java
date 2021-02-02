package com.loteia.sorteio.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;

import lombok.Getter;


@Entity
@Getter
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class Usuario {
	
	public Usuario() {
	}
	
	public Usuario(String email) {
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

//	@OneToMany(cascade = CascadeType.ALL)
//	private Set<Aposta> apostas = new HashSet();

//	public void setApostas(Set<Set<Integer>> apostas) {
//		this.apostas = apostas;
//	}


	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Usuario{" +
				"email='" + email + '\'' +
				'}';
	}
}
