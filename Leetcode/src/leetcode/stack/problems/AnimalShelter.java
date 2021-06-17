/**
 * 
 */
package leetcode.stack.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardik
 *
 *         Date : 21-Apr-2021 Time : 9:05:34 pm
 */

class Animal {
	private int order;
	protected String name;

	/**
	 * 
	 */
	public Animal(String name) {
		this.name = name;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * 
	 */
	public boolean isOlderThan(Animal a) {
		return this.order < a.order;

	}
}

class Dog extends Animal {
	/**
	 * 
	 */
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	/**
	 * 
	 */
	public Cat(String n) {
		super(n);
	}
}

public class AnimalShelter {

	LinkedList<Dog> dog = new LinkedList<Dog>();
	LinkedList<Cat> cat = new LinkedList<Cat>();
	private int order = 0;

	/*
	 * Order is used as a sort of timestamp, so that we can compare the insertion
	 * order of a dog to a cat.
	 */
	public void push(Animal a) {
		a.setOrder(order);
		this.order++;
		if (a instanceof Dog)
			dog.addLast((Dog) a);
		else if (a instanceof Cat)
			cat.addLast((Cat) a);
	}

	public Animal dequueAny() {
		if (dog == null)
			return dequeueCats();
		if (cat == null)
			return dequeueDogs();
		Dog d = dog.peek();
		Cat c = cat.peek();
		if (d.isOlderThan(c)) {
			return dequeueDogs();
		} else {
			return dequeueCats();
		}
	}

	/**
	 * @return
	 */
	private Dog dequeueDogs() {
		return dog.poll();
	}

	/**
	 * @return
	 */
	private Cat dequeueCats() {
		return cat.poll();
	}

}
