package bowl;

import zooCharacter.Animal;

public class FruitBowl implements Bowl {

	@Override
	public void feed(Animal animal) {
		System.out.println("Feed function in FruitBowl and feeding Animal is " + animal.getName());
	}

}
