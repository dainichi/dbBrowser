package testproject.dataobjects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MultiMap<K, V> {
	Map<K,HashSet<V>> map = new HashMap<>();

	public void put(K key, V value) {
		if(map.containsKey(key)) {
			map.get(key).add(value);
		}
		else {
			HashSet<V> set = new HashSet<>();
			set.add(value);
			map.put(key, set);
		}
	}
	
	public Set<V> get(K key) {
		return map.get(key);
	}
}
