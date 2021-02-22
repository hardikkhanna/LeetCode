/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Feb 14, 2021 Time : 4:38:12 PM
 */
public class MapNode<K, V> {

	K key;
	V value;
	MapNode<K, V> next;
	
	public MapNode(K key, V value){
		this.key = key;
		this.value = value;
	}
}