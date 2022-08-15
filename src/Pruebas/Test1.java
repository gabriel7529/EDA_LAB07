package Pruebas;

import HashTable.Hash;

public class Test1 {
	public static void main(String[] args) {
		Hash nombres = new Hash(25);
		
		nombres.put(25, "Gonzalo Paredes");
		nombres.put(34, "Mario Vargas");
		nombres.put(15, "Deiman Galvez");
		nombres.put(96, "Osmar Gonzales");

		System.out.println(nombres);
		nombres.put(115, "Charo Gonzales");
		System.out.println(nombres);
		nombres.put(315, "Jorge Gonzales");
		System.out.println(nombres);
		nombres.put(96, "Marco Gonzales");
		System.out.println(nombres);
		
		
	}
}
