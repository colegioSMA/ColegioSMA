package sma;

import java.util.ArrayList;
import java.util.List;



public class Main {

	public static void main(String []args) {
		// TODO Auto-generated constructor stub
		List<Integer> listaIntegers = 
				new ArrayList<>();
		listaIntegers.add(4);
		listaIntegers.add(8);
		int suma = 0;
		for (int i=0;i<listaIntegers.size();i++) {
			suma = +listaIntegers.get(i);
		}
		System.out.println(suma);
	}

}
