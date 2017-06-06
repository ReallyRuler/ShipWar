package model;

public interface ShipSubject {
	public void registerObserver(ShipObserver oberver);
	public void removeObsever(ShipObserver oberver);
	public void notifyObervers();
}
