package com.loteia.sorteio.usuarios;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Set;

import com.loteia.sorteio.Sorteador;

public class TestaUsuarios {

	private static final int QTDE_NUMEROS_SORTEADOS = 3;
	private static final int MINIMO_SORTEADO = 1;
	private static final int MAXIMO_SORTEADO = 60;

	public static void main(String[] args) {
		long tempoInicial = System.currentTimeMillis();

		LinkedList<Set<Integer>> apostasJoao = new LinkedList<Set<Integer>>(); //0,348 ms //mantem a ordem de insercao //para 60/3 23,852 ms[/ccontens] - 0,329 ms[s/contains]

		boolean contains = false;
		var result = calculaMaximoArranjosPossiveis();

		do {
			Set<Integer> aposta = Sorteador.sorteia(QTDE_NUMEROS_SORTEADOS, MINIMO_SORTEADO, MAXIMO_SORTEADO);
//			contains = apostasJoao.contains(aposta);// Qual a melhor performance de buscaaqui?
//			if (!contains) { // hashMap.get("joao").add(aposta);
				apostasJoao.add(aposta);
//			}
		} while (apostasJoao.size()<34220);
//	} while (apostasJoao.size()<487635);
		
		System.out.println("Apostas do Joao:" + apostasJoao);
//		System.out.println("qtdeCombinacoesPossiveis:" + result);
		long tempoFinal = System.currentTimeMillis();
		System.err.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
	}

	private static BigInteger calculaMaximoArranjosPossiveis() {
		BigInteger n = factorialHavingLargeResult(MAXIMO_SORTEADO);
		BigInteger p = factorialHavingLargeResult(QTDE_NUMEROS_SORTEADOS);
		BigInteger subtract = factorialHavingLargeResult(MAXIMO_SORTEADO - QTDE_NUMEROS_SORTEADOS);
		BigInteger result = n.divide(subtract).divide(p);
		return result;
	}

	public static BigInteger factorialHavingLargeResult(int n) {
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= n; i++)
			result = result.multiply(BigInteger.valueOf(i));
		return result;
	}
}



//Set<Set<Integer>> apostasJoao = new HashSet<Set<Integer>>(); //5,565 ms //nao mantem ordem de insercao
//LinkedHashSet<Set<Integer>> apostasJoao = new LinkedHashSet<Set<Integer>>(); //6,470 ms //mantem a ordem de insercao
//LinkedHashSet<Set<Integer>> apostasJoao = new LinkedHashSet<Set<Integer>>(); //6,470 ms
//// exemplo manual para garantir insercoes sem duplicar e manter a ordem de insercao
//Set<Integer> aposta14 = new HashSet<>(Arrays.asList(Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(7)));
//apostasJoao.add(aposta14);
//Set<Integer> aposta1 = new HashSet<>(Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)));
//apostasJoao.add(aposta1);
//Set<Integer> aposta12 = new HashSet<>(Arrays.asList(Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2)));
//apostasJoao.add(aposta12);
//Set<Integer> aposta13 = new HashSet<>(Arrays.asList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(6)));
//apostasJoao.add(aposta13);
