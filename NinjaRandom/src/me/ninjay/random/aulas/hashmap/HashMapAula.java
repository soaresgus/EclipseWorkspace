package me.ninjay.random.aulas.hashmap;

import java.util.HashMap;




public class HashMapAula{
	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<>(); // Se você já entende um pouco deve saber que a String é o texto e double o valor
             
		map.put("Teste", (double) 15); //Aqui como o primeiro é string colocamos o texto da string e no segundo como é double colocamos um valor
        System.out.println("O valor do teste é: "+map.get("Teste"));
	}
	
	

}
