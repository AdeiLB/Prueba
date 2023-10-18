package tema_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PruebaListas {

	public static void main(String[] args) {
		
		List<Integer> listaEnt = new ArrayList<>();
		
		listaEnt.add(-4);
		listaEnt.add(6);
		listaEnt.add(-9);
		listaEnt.add(1);
		
		System.out.println(listaEnt.size()+"\n");
		
		System.out.println(listaEnt.isEmpty()+"\n");
		
		for (Integer i : listaEnt) {
			System.out.println("/////"+i);
		}
		
		//Ordenar lista de Integer
		
		Collections.sort(listaEnt);
		
		int indice = 0;
		while(indice < listaEnt.size()) {
			System.out.println(listaEnt.get(indice));
			indice++;
		}
		
		
		
		
		
	}
}
