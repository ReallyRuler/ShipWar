package model;

import util.Location;

public interface ShipModelInterface {
	public void initShip(int shipType,Location[] locs);
	public boolean setShip();
	public boolean hurtShip(Location loc);
	public boolean ifDestroy();
}
