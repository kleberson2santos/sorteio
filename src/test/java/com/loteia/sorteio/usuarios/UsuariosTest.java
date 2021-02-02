package com.loteia.sorteio.usuarios;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class UsuariosTest {
	
	@Test
	public void givenHashMapAndTreeMap_whenputDuplicates_thenOnlyUnique() {
	    Map<Integer, String> treeMap = new HashMap<>();
	    treeMap.put(1, "Baeldung");
	    treeMap.put(1, "Baeldung");

	    assertTrue(treeMap.size() == 1);

	    Map<Integer, String> treeMap2 = new TreeMap<>();
	    treeMap2.put(1, "Baeldung");
	    treeMap2.put(1, "Baeldung");

	    assertTrue(treeMap2.size() == 1);
	}

}
