package com.loteia.sorteio;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import com.loteia.sorteio.model.Aposta;
import com.loteia.sorteio.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loteia.sorteio.api.model.UsuarioInput;
import com.loteia.sorteio.model.Usuario;
import com.loteia.sorteio.repository.UsuarioRepository;

@RestController
@RequestMapping("/sorteio")
public class SorteioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ApostaRepository apostaRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	@GetMapping
	public Aposta sortear(@Valid @RequestBody UsuarioInput input) {
		
		var usuario = usuarioRepository.findByEmail(input.getEmail()).orElse(new Usuario(input.getEmail()));
		
		long tempoInicial = System.currentTimeMillis();
		var aposta1= new Aposta(Sorteador.sorteia(2, 1, 5), usuario);
		apostaRepository.save(aposta1);
		System.out.println(aposta1.getNumeros());
		long tempoFinal = System.currentTimeMillis();
		System.err.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(apostaRepository.findAll());
		return aposta1;
	}


}
