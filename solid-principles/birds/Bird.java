package birds;

import zooCharacter.Animal;

/*
 * Bird class is open for extension and closed for modification.
 * If in the future, if someone wants to add new bird they can simply extend this class to provide new implementation.
 * This class follows Open-Closed principle.
 */
public abstract class Bird extends Animal {
	public Bird(String name) {
		super(name);
	}
}
