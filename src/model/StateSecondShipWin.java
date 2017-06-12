package model;

public class StateSecondShipWin implements GameStateInterface {

	private StateSecondShipWin() {
		// TODO Auto-generated constructor stub
	}
	
	private static StateSecondShipWin stateSecondShipWin;
	public static StateSecondShipWin getStateSecondShipWin(){
		if(stateSecondShipWin==null)
			return stateSecondShipWin=new StateSecondShipWin();
		else 
			return stateSecondShipWin;
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
		return null;
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
