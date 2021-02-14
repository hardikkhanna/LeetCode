/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;

/**
 * @author NIPC-43
 *
 *         Date : Feb 14, 2021 Time : 4:40:54 PM
 */
public class Map<K, V> {

	ArrayList<MapNode<K, V>> bucketList;
	int size;
	int numBuckets;

	public Map() {
		numBuckets = 20;
		bucketList = new ArrayList<MapNode<K, V>>();
		for (int i = 0; i < 20; i++) {
			bucketList.add(null);
		}
	}

	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = bucketList.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = bucketList.get(bucketIndex);
		MapNode<K, V> newElement = new MapNode<K, V>(key, value);
		size++;
		newElement.next = head;
		bucketList.set(bucketIndex, newElement);
		double loadFactor = (1.0 * size) / numBuckets;
		if (loadFactor > 0.7) {
			rehash();
		}

	}

	/**
	 * 
	 */
	private void rehash() {
		ArrayList<MapNode<K, V>> temp = bucketList;
		bucketList = new ArrayList<MapNode<K, V>>();
		for (int i = 0; i < numBuckets * 2; i++) {
			bucketList.add(null);
		}
		size = 0;
		numBuckets = numBuckets * 2;
		for (int i = 0; i < temp.size(); i++) {
			MapNode<K, V> head = temp.get(i);
			while (head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}
	}

	/**
	 * @param key
	 * @return
	 */
	private int getBucketIndex(K key) {
		int hashcode = key.hashCode();
		return hashcode % numBuckets;
	}

	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = bucketList.get(bucketIndex);
		MapNode<K, V> prev = null;
		while (head != null) {
			if (head.key.equals(key)) {
				size--;
				if (prev == null) {
					bucketList.set(bucketIndex, head.next);
				} else {
					prev.next = head.next;
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}

	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> head = bucketList.get(bucketIndex);
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
		}
		return null;
	}

	/**
	 * @return
	 */
	public double loadFactor() {
		return (1.0 * size) / numBuckets;
	}

}
