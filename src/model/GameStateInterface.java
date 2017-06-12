package model;

public interface GameStateInterface {
	
	public GameStateInterface gameInit();
	public GameStateInterface firstShipAttact();
	public GameStateInterface secondShipAttact();
	public GameStateInterface firstShipAttactMiss();
	public GameStateInterface secondShipAttactMiss();
	public GameStateInterface firstShipDestroy();
	public GameStateInterface secondShipDestroy();
}
