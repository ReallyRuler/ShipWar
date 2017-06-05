package test;

import Constant.SHIPTYPE;
import view.MapModel;
import view.ShipModel;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShipModel shipModel=new ShipModel();
		
		MapModel mapModel=new MapModel();
		
		shipModel.registerObserver(mapModel);
		
		shipModel.initShip(SHIPTYPE.TINY_SHIP);
		
		shipModel.hurtShip();
	}

}
