package Pruebas;

import HashTable.Hash;

public class Test11111111111 {
	public static void main(String[] args) {
		Hash nombres = new Hash(25);
		
		nombres.put(25, "Gonzalo Paredes");
		nombres.put(34, "Mario Vargas");
		nombres.put(15, "Deiman Galvez");
		nombres.put(96, "Osmar Gonzales");
		
		System.out.println(nombres);
		System.out.println("Pruebas del método Get");
		System.out.println(nombres.get(25));
		System.out.println("Pruebas del método Remove");
		System.out.println(nombres.remove(25));
		System.out.println(nombres.get(25));
		System.out.println("Pruebas del método Put en la misma clave");
		System.out.println(nombres.put(34,"Luis Angel"));
		System.out.println(nombres);
	}
}
