package com.loteia.sorteio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

@Component
public class Sorteador {
	public static Set<Integer> sorteia ( int quantidadeDeElementosASortear, int limiteInferior, int limiteSuperior){
		 
		        // cria a lista de elementos
		        List<Integer> elementos = new ArrayList<Integer>(limiteSuperior - limiteInferior + 1);
		        for (int i = limiteInferior; i <= limiteSuperior; i++){
		            elementos.add(Integer.valueOf(i));
		        }
		         
		        // altera a ordem aleatóriamente
		        Collections.shuffle (elementos) ;
		          
		        // sorteia o numero de elementos necessários
		         
		        Set<Integer> resultado = new TreeSet<Integer>(elementos.subList(0,quantidadeDeElementosASortear));
		         
		        return resultado;
		 
		}
		  

}
