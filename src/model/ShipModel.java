package model;

import java.util.ArrayList;

import util.Location;

public class ShipModel implements ShipSubject,ShipModelInterface{
	
	private ArrayList observers;
	
	private AbstractShip ship;
	
	@Override
	public boolean initShip(int shipType,Location[] locs) {
		// TODO Auto-generated method stub
		ship=ShipFactory.createShip(shipType);
		
		ship.loc=locs;
		
		
		try {
			notifyObervers();
			return true;
		} catch (ShipLocationException e) {
			e.printStackTrace();
			ship=null;
			return false;
		}
	}
	
	@Override
	public void hurtShip() {
		// TODO Auto-generated method stub
		ship.nhealth=ship.nhealth-1;
		
		notifyObervers();
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
	public void notifyObervers() {
		// TODO Auto-generated method stub
		for(int i=0;i<observers.size();i++){
			ShipObserver observer = (ShipObserver) observers.get(i);
			observer.update(ship);
		}
	}
		
}
