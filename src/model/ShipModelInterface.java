package model;

import util.Location;

public interface ShipModelInterface {
	public boolean initShip(int shipType,Location[] locs);
	public boolean hurtShip(Location loc);
	public boolean ifDestroy();
}
