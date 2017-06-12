package model;

import constant.ATTACTORDER;
import util.Location;

public class GameProcess {
	GameStateInterface stateInit;
	GameStateInterface stateReady;
	GameStateInterface stateFirstShipTurn;
	GameStateInterface stateFirstShipWin;
	GameStateInterface stateSecondShipTurn;
	GameStateInterface stateSecondShipWin;
	
	GameStateInterface state;
	
	ShipModel[] firstShips;
	ShipModel[] secondShips;
	MapModel firstMap;
	MapModel secondMap;
	
	private int firstDestroyNum=0;
	private int secondDestroyNum=0;
	
	private static GameProcess gameProcess;
	
	private GameProcess(){
		
	}
	
	public static GameProcess getGameProcess(){
		if(gameProcess==null){
			gameProcess=new GameProcess();
		}
		return gameProcess;
	}
	
	public void gameStart(){
		try {
			stateInit=StateInit.getStateInit();
			state=stateInit;
			
			if(state==null)
				throw new GameProcessExcpetion();
		} catch (GameProcessExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gameReady(ShipModel[] firstShips,ShipModel[] secondShips,MapModel firstMap,MapModel secondMap){
		try {
			this.firstShips=firstShips;
			this.firstMap=firstMap;
			this.secondShips=secondShips;
			this.secondMap=secondMap;
			
			for(int i=0;i<firstShips.length;i++){
				this.firstShips[i].registerObserver(firstMap);
				this.firstShips[i].setShip();
				
				this.secondShips[i].registerObserver(secondMap);
				this.secondShips[i].setShip();
			}
			state=state.gameInit();
			if(state==null)
				throw new GameProcessExcpetion();
			
			System.out.println("Game is ready");
		} catch (GameProcessExcpetion e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void chooseAttactOrder(int attactOrder){
		try {
			if(attactOrder==ATTACTORDER.FIRST_ATTACT){
				state=state.firstShipAttact();
			}
			else if(attactOrder==ATTACTORDER.SECOND_ATTACT){
				state=state.secondShipAttact();
			}
			
			if(state==null)
				throw new GameProcessExcpetion();
			
		} catch (GameProcessExcpetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int nextAttact(Location loc){
		boolean hurt=false;
		
		if(state instanceof StateFirstShipTurn == true ){
			System.out.println("First ship turn");
			for(int i=0;i<secondShips.length;i++){
				if(secondShips[i].hurtShip(loc)==true){
					hurt=true;
					
					if(secondShips[i].ifDestroy()==true)
						secondDestroyNum++;
					
					break;
				}
			}
			if(secondDestroyNum==secondShips.length){
				state=state.secondShipDestroy();
				System.out.println("All second ships destroy");
				return ATTACTORDER.NULL_ATTACI;
			}

			if(hurt==false){
				state=state.firstShipAttactMiss();
				System.out.println("First ship miss attact");
				return ATTACTORDER.SECOND_ATTACT;
			}
			else{
				state=state.firstShipAttact();
				System.out.println("First ship attact success");
				return ATTACTORDER.FIRST_ATTACT;
			}
		}
		
		hurt=false;
		if(state instanceof StateSecondShipTurn==true){
			System.out.println("Second ship turn");
			for(int i=0;i<firstShips.length;i++){
				if(firstShips[i].hurtShip(loc)==true){
					hurt=true;
					
					if(firstShips[i].ifDestroy()==true)
						firstDestroyNum++;
					
					break;
				}
			}
			
			if(firstDestroyNum==firstShips.length){
				state=state.firstShipDestroy();
				System.out.println("All first ships destroy");
				return ATTACTORDER.NULL_ATTACI;
			}
			
			if(hurt==false){
				state=state.secondShipAttactMiss();
				System.out.println("Second ship attact miss");
				return ATTACTORDER.FIRST_ATTACT;
			}
			else{
				state=state.secondShipAttact();
				System.out.println("Second ship attact success");
				return ATTACTORDER.SECOND_ATTACT;
			}
		}
		else
			return ATTACTORDER.NULL_ATTACI;
	}
}
