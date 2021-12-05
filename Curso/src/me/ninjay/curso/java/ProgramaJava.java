package me.ninjay.curso.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ProgramaJava {

	public static void main(String[] args) {
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Ninjay_");
		nomes.add("zBetaCodes_");
		nomes.add("EduardMaster");
		nomes.add("DanielFR");

		System.out.println(nomes);
		nomes.remove("EduardMaster");
		nomes.remove("zBetaCodes_");
		System.out.println(nomes);
		if (nomes.contains("zBetaCodes_")) {
			System.out.println("abc");
		} else {
			System.out.println("opa");
		}
		for (String nome : nomes) {
			System.out.println("Nome: " + nome);
		}
		HashMap<String, Double> contas = new HashMap<>();
		contas.put("zBetaCodes_", 0d);
		contas.put("Ninjay_", 1000d);
		contas.put("EduardMaster", 25d);
		contas.put("DanielFR", 80d);
		List<Entry<String, Double>> listaordenada = contas.entrySet().stream().sorted(Comparator.comparing(Entry::getValue)).collect(Collectors.toList());
        Collections.reverse(listaordenada);
		System.out.println(listaordenada);
	}

}
