package model;

import constant.SHIPTYPE;

public class ShipFactory {
	public static AbstractShip createShip(int shipType){
		if(shipType==SHIPTYPE.TINY_SHIP)
			return new TinyShip();
		else if(shipType==SHIPTYPE.SMALL_SHIP)
			return new SmallShip();
		else if(shipType==SHIPTYPE.MEDIUM_SHIP)
			return new MediumShip();
		else if(shipType==SHIPTYPE.HUGE_SHIP)
			return new HugeShip();
		else
			return null;
	}
}
