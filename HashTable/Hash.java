public class Hash implements HashTable {
	private ListNode[] table;
	private int count;

	private static class ListNode {
		Integer key;
		String value;
		ListNode next;
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
		return count;
	}

	@Override
	public boolean isEmpty() {
		if(count != 0) {
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
	            
	         if (list.key.equals(key))
	            break;
	         list = list.next;
	      }
	      
	      
	      if (list != null) {
	    	 String aux = list.value;
	         list.value = value;
	         return aux;
	      }
	      else {
	             
	         if (count >= 0.75*table.length) {
	            resize();
	            bucket = hash(key);  
	         }
	         ListNode newNode = new ListNode();
	         newNode.key = key;
	         newNode.value = value;
	         newNode.next = table[bucket];
	         table[bucket] = newNode;
	         count++;  
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
		String str="";
		for(int i=0; i<table.length;i++) {
			if(table[i] != null )
				str += i +"{" + "key: " + table[i].key + ", " + "value: " +table[i].value  +"}\n";
		}
		return str;
	}
	
}
