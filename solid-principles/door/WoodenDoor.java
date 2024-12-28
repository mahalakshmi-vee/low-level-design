package door;

public class WoodenDoor implements Door {
	private int durability = 150;

	@Override
	public void resistAttack(int power) {
		if (power < durability) {
			System.out.println("The wooen door resist the attack!");
		} else if (power == durability) {
			System.out.println("The wooden door is slightly damaged but holds!");
		} else {
			System.out.println("The wooden door break under thr force!");
		}
	}
}
