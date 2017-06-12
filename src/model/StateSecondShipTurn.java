package model;

public class StateSecondShipTurn implements GameStateInterface {

	private StateSecondShipTurn(){
		
	}
	
	private static StateSecondShipTurn stateSecondShipTurn;
	public static StateSecondShipTurn getStateSecondShipTurn(){
		if(stateSecondShipTurn==null)
			return stateSecondShipTurn=new StateSecondShipTurn();
		else 
			return stateSecondShipTurn;
	}
	
	@Override
	public GameStateInterface gameInit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameStateInterface firstShipAttact() {
		// TODO Auto-generated method stub
		return null;
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
		return StateFirstShipTurn.getStateFirstShipTurn();
	}

	@Override
	public GameStateInterface firstShipDestroy() {
		// TODO Auto-generated method stub
		return StateSecondShipWin.getStateSecondShipWin();
	}

	@Override
	public GameStateInterface secondShipDestroy() {
		// TODO Auto-generated method stub
		return null;
	}

}
