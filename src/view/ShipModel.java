package view;

import java.util.ArrayList;

public class ShipModel implements ShipSubject,ShipModelInterface{
	
	private ArrayList observers;
	
	private AbstractShip ship;
	
	@Override
	public void initShip(int shipType) {
		// TODO Auto-generated method stub
		ship=ShipFactory.createShip(shipType);
		
		System.out.println("ShipModel.initShip()");
		
		notifyObervers();
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
