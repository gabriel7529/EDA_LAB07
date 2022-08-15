package Pruebas;

import HashTable.Hash;

public class Test {
	public static void main(String[] args) {
		Hash nombres = new Hash(25);
		
		nombres.put(25, "Gonzalo Paredes");
		nombres.put(34, "Mario Vargas");
		nombres.put(15, "Deiman Galvez");
		nombres.put(96, "Osmar Gonzales");

		nombres.put(96, "Carlos Gonzales");
		System.out.println(nombres);
		nombres.put(96, "Charo Gonzales");
		System.out.println(nombres);
		nombres.put(96, "Marco Gonzales");
		System.out.println(nombres);
	}
}
