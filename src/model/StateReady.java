package model;

public class StateReady implements GameStateInterface {

	private static StateReady stateReady;
	public static StateReady getStateReady(){
		if(stateReady==null)
			return stateReady=new StateReady();
		else 
			return stateReady;
	}
	
	@Override
	public GameStateInterface gameInit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameStateInterface firstShipAttact() {
		// TODO Auto-generated method stub
		return StateFirstShipTurn.getStateFirstShipTurn();
	}

	@Override
	public GameStateInterface secondShipAttact() {
		// TODO Auto-generated method stub
		return StateSecondShipTurn.getStateSecondShipTurn();
	}

	@Override
	public GameStateInterface firstShipAttactMiss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameStateInterface secondShipAttactMiss() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameStateInterface firstShipDestroy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameStateInterface secondShipDestroy() {
		// TODO Auto-generated method stub
		return null;
	}

}
