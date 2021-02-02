package com.loteia.sorteio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private Set<Integer> numeros;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

	public Aposta(Set<Integer> numeros, Usuario usuario) {
		this.numeros = numeros;
		this.usuario = usuario;
	}

    @Override
    public String toString() {
        return "\nAposta{" +
                "id=" + id +
                ", numeros=" + numeros +
                ", usuario=" + usuario +
                '}';
    }
}
