package model;

public class StateInit implements GameStateInterface {
	
	private static StateInit stateInit;
	public static StateInit getStateInit(){
		if(stateInit==null){
			stateInit=new StateInit();
			return stateInit;
		}
		else 
			return stateInit;
	}
	
	@Override
	public GameStateInterface gameInit() {
		// TODO Auto-generated method stub
		return StateReady.getStateReady();
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
