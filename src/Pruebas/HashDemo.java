package HashTable;

public class HashDemo {

	public static void main(String[] args) {

		Hash usuarios = new Hash(12);
		User u = new User(2, "lucia", "luc@unsa.edu.pe");
		User d = new User(5, "manuel", "powc@unsa.edu.pe");
		User a = new User(4, "lucas", "lsc@unsa.edu.pe");
		User b = new User(6, "mery", "lcc@unsa.edu.pe");
		User c = new User(8, "mario", "afg@unsa.edu.pe");
		usuarios.put(u.hashCode(), u);
		usuarios.put(d.hashCode(), d);
		usuarios.put(a.hashCode(), a);
		usuarios.put(b.hashCode(), b);
		usuarios.put(c.hashCode(), c);
		System.out.println(usuarios.size());
		System.out.println(usuarios);
		usuarios.remove(u.hashCode());
		System.out.println(usuarios);
		System.out.println(usuarios.get(d.hashCode()));
		
	}
}
