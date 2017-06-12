package model;

public class StateFirstShipTurn implements GameStateInterface {

	private static StateFirstShipTurn stateFirstShipTurn;
	public static StateFirstShipTurn getStateFirstShipTurn(){
		if(stateFirstShipTurn==null)
			return stateFirstShipTurn=new StateFirstShipTurn();
		else 
			return stateFirstShipTurn;
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
		return null;
	}

	@Override
	public GameStateInterface firstShipAttactMiss() {
		// TODO Auto-generated method stub
		return StateSecondShipTurn.getStateSecondShipTurn();
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
		return StateFirstShipWin.getStateFirstShipWin();
	}

}
