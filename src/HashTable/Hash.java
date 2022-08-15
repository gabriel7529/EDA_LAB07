package HashTable;

public class Hash implements HashTable {
	private ListNode[] table;
	private int count;
	private int count2;

	private static class ListNode {
		Integer key = null;
		String value = null;
		ListNode next = null;
		ListNode nextList = null;

		public String toString() {
			return " {key: " + key + ", " + "value: " + value + " } ";
		}
	}

	public Hash() {
		table = new ListNode[32];
	}

	public Hash(int M) {
		if (M <= 0)
			throw new IllegalArgumentException("Valor no permitido");
		table = new ListNode[M];
	}

	@Override
	public int size() {
		return count + count2;
	}

	@Override
	public boolean isEmpty() {
		if (count != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		int bucket = hash(key);
		ListNode list = table[bucket];
		while (list != null) {

			if (list.key.equals(key))
				return true;
			list = list.next;
		}

		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		int bucket = hash(value);
		ListNode list = table[bucket];
		while (list != null) {

			if (list.value.equals(value))
				return true;
			list = list.next;
		}
		return false;
	}

	@Override
	public String get(Integer key) {
		int bucket = hash(key);
		ListNode list = table[bucket];
		while (list != null) {

			if (list.key.equals(key))
				return list.value;
			list = list.next;
		}
		return null;
	}

	@Override
	public String put(Integer key, String value) {
		assert key != null : "The key must be non-null";

		int bucket = hash(key);

		ListNode list = table[bucket];

		while (list != null) {

			if (list.key == key) {
				break;
			}
			list = list.next;
		}
		if (list != null) {
			if (list.nextList == null) {
				ListNode aux = new ListNode();
				aux.key = list.key;
				aux.value = list.value;
				list.nextList = aux;
				count2++;
			} else {
				ListNode aux = list.nextList;
				while (aux.nextList != null)
					aux = aux.nextList;
				ListNode nuevo = new ListNode();
				nuevo.key = list.key;
				nuevo.value = list.value;
				aux.nextList = nuevo;
				count2++;

			}
			String aux = list.value;
			list.value = value;
			return aux;
		} else {
			if (count >= 0.75 * table.length) {
				resize();
				bucket = hash(key);
			}
			if (table[bucket] == null) {
				ListNode newNode = new ListNode();
				newNode.key = key;
				newNode.value = value;
				newNode.next = table[bucket];
				table[bucket] = newNode;
				count++;
				return null;
			}

			ListNode newNode = new ListNode();
			newNode.key = key;
			newNode.value = value;
			newNode.next = table[bucket];
			newNode.nextList = table[bucket];
			table[bucket] = newNode;
			count2++;

		}
		return null;
	}

	@Override
	public String remove(Object key) {
		int bucket = hash(key);
		String aux = null;

		if (table[bucket] == null) {
			return null;
		}

		if (table[bucket].key.equals(key)) {
			aux = table[bucket].value;
			table[bucket] = table[bucket].next;
			count--;
			return aux;
		}

		ListNode prev = table[bucket];
		ListNode curr = prev.next;
		while (curr != null && !curr.key.equals(key)) {
			curr = curr.next;
			prev = curr;
		}

		if (curr != null) {
			aux = prev.next.value;
			prev.next = curr.next;
			count--;
		}
		return aux;
	}

	@Override
	public void clear() {
		this.table = new ListNode[32];
		this.count = 0;

	}

	private int hash(Object key) {
		return (Math.abs(key.hashCode())) % table.length;
	}

	private void resize() {
		ListNode[] newtable = new ListNode[table.length * 2];
		for (int i = 0; i < table.length; i++) {

			ListNode list = table[i];
			while (list != null) {

				ListNode next = list.next;

				int hash = (Math.abs(list.key.hashCode())) % newtable.length;

				list.next = newtable[hash];
				newtable[hash] = list;
				list = next;
			}
		}
		table = newtable;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				str += "Indice " + i + ": " + "{" + "key: " + table[i].key + ", " + "value: " + table[i].value ;
				if (table[i].nextList != null) {
					ListNode count = table[i];
					while (count.nextList != null) {
						str += "} " + count.nextList;
						count = count.nextList;
					}
				}
				str += "}\n";
			}
		}
		return str;
	}
}
