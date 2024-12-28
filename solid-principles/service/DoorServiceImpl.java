package serviceImpl;

import door.Door;
import service.DoorService;

public class DoorServiceImpl implements DoorService {
	@Override
	public void resistAttack(Door door, int power) {
		door.resistAttack(power);
	}
}
