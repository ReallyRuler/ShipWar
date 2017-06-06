package model;

import util.Location;

public interface ShipModelInterface {
	public boolean initShip(int shipType,Location[] locs);
	public void hurtShip();
	public boolean ifDestroy();
}
