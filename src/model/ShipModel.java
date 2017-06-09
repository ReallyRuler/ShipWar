package model;

import java.util.ArrayList;

import constant.UPDATATYPE;
import util.Location;

public class ShipModel implements ShipSubject,ShipModelInterface{
	
	private ArrayList observers;
	
	private AbstractShip ship;
	
	@Override
	public boolean initShip(int shipType,Location[] locs) {
		// TODO Auto-generated method stub
		ship=ShipFactory.createShip(shipType);
		
		ship.locs=locs;
		
		
		try {
			initNotifyObervers();
			return true;
		} catch (ShipLocationException e) {
			e.printStackTrace();
			ship=null;
			return false;
		}
	}
	
	@Override
	public boolean hurtShip(Location loc) {
		// TODO Auto-generated method stub
		boolean ifHurt=false;
		ship.hurtLoc=loc;
		
		for(int i=0;i<ship.locs.length;i++){
			
			if(loc.locaX==ship.locs[i].locaX&&loc.locaY==ship.locs[i].locaY){
				ship.nhealth=ship.nhealth-1;
				ship.locs[i].locaX=-1;
				ship.locs[i].locaY=-1;
				ifHurt=true;
				break;
			}
		}
		try {
			hurtNotifyObervers();
			return true;
		} catch (ShipLocationException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean ifDestroy() {
		// TODO Auto-generated method stub
		if(ship.nhealth==0)
			return true;
		return false;
	}
	
	@Override
	public void registerObserver(ShipObserver observer) {
		// TODO Auto-generated method stub
		if(observers == null)
			observers = new ArrayList<>();
		observers.add(observer);
	}
	
	@Override
	public void removeObsever(ShipObserver observer) {
		// TODO Auto-generated method stub
		int i=observers.indexOf(observer);
		if(i>=0){
			observers.remove(i);
		}
	}
	
	@Override
	public void initNotifyObervers() {
		// TODO Auto-generated method stub
		if(observers==null)
			return;
		
		for(int i=0;i<observers.size();i++){
			ShipObserver observer = (ShipObserver) observers.get(i);
			observer.update(ship,UPDATATYPE.INIT_UPDATA);
		}
	}
	
	public void hurtNotifyObervers() {
		// TODO Auto-generated method stub
		if(observers==null)
			return;
		
		for(int i=0;i<observers.size();i++){
			ShipObserver observer = (ShipObserver) observers.get(i);
			observer.update(ship,UPDATATYPE.HURT_UPDATA);
		}
	}
		
}
