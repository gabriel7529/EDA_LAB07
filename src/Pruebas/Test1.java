public class Test1 {
	public static void main(String[] args) {
		Hash nombres = new Hash(25);
		
		nombres.put(25, "Gonzalo Paredes");
		nombres.put(34, "Mario Vargas");
		nombres.put(15, "Deiman Galvez");
		nombres.put(96, "Osmar Gonzales");
		
		System.out.println(nombres);
		
	}
}
