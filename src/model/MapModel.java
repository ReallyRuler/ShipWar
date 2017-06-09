package model;

import constant.GRIDTYPE;
import constant.UPDATATYPE;

public class MapModel implements ShipObserver,MapModelInterfate {

	private int maxX=0;
	private int maxY=0;
	private int[][] mapGrid;
	AbstractShip ship;
	MapCheck mapCheck;
	
	@Override
	public void initMapGrid(int maxX,int maxY) {
		// TODO Auto-generated method stub
		this.maxX=maxX;
		this.maxY=maxY;
		mapGrid=new int[maxX][maxY];
		
		for(int i=0;i<maxX;i++){
			for(int j=0;j<maxY;j++){
				mapGrid[i][j]=GRIDTYPE.NO_SHIP;
			}
		}
		
		mapCheck=new MapCheck(maxX, maxY, mapGrid);
	}
	
	
	@Override
	public void update(AbstractShip ship,int updataType) {
		// TODO Auto-generated method stub
		
		if(updataType==UPDATATYPE.INIT_UPDATA){
			if(mapCheck.initCheck(ship.locs)==false){
				throw new ShipLocationException("Init location error");
			}

			this.ship=ship;		
			for(int i=0;i<ship.length;i++){
				mapGrid[ship.locs[i].locaX][ship.locs[i].locaY]=GRIDTYPE.LIVE_SHIP;
			}
		}
		
		else if(updataType==UPDATATYPE.HURT_UPDATA){
			if(mapCheck.hurtCheck(ship.hurtLoc)==false){
				throw new ShipLocationException("Hurt location error");
			}
			this.ship=ship;
			
			if(mapGrid[ship.hurtLoc.locaX][ship.hurtLoc.locaY]==GRIDTYPE.NO_SHIP){
				mapGrid[ship.hurtLoc.locaX][ship.hurtLoc.locaY]=GRIDTYPE.HURT_GRID;
				System.out.println("no ship hurt");
			}
			
			else if(mapGrid[ship.hurtLoc.locaX][ship.hurtLoc.locaY]==GRIDTYPE.LIVE_SHIP){
				mapGrid[ship.hurtLoc.locaX][ship.hurtLoc.locaY]=GRIDTYPE.DEAD_SHIP;
				System.out.println("ship hurt");
			}
		}
		System.out.println("something in mapmodel change");
	}

}
