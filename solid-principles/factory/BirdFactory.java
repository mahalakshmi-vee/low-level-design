package appMain;

import birds.Bird;
import birds.Kiwi;
import birds.Parrot;
import birds.Peacock;

public class BirdFactory {
	public static Bird getBird(String birdType) throws Exception {
		switch (birdType) {
		case "Parrot":

			return new Parrot("Parrot");
		case "Peacock":

			return new Peacock("Peacock");
		case "Kiwi":

			return new Kiwi("Kiwi");
		default:

			throw new Exception("Kindly choose valid bird option");
		}
	}
}
