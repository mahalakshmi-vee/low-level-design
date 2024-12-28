package door;

public class IronDoor implements Door {
	private int durability = 150;

	@Override
	public void resistAttack(int power) {
		if (power < durability) {
			System.out.println("The iron door resist the attack!");
		} else if (power == durability) {
			System.out.println("The iron door is slightly damaged but holds!");
		} else {
			System.out.println("The iron door break under thr force!");
		}
	}

}
