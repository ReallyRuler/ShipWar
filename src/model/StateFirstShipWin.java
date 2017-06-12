package model;

public class StateFirstShipWin implements GameStateInterface {

	private static StateFirstShipWin stateFirstShipWin;
	public static StateFirstShipWin getStateFirstShipWin(){
		if(stateFirstShipWin==null)
			return stateFirstShipWin=new StateFirstShipWin();
		else 
			return stateFirstShipWin;
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
