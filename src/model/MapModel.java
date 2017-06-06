package model;

import constant.GRIDTYPE;

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
	
	public void updataMapGrid(){
		for(int i=0;i<ship.length;i++){
			mapGrid[ship.loc[i].locaX][ship.loc[i].locaY]=GRIDTYPE.LIVE_SHIP;
		}
	}
	
	@Override
	public void update(AbstractShip ship) {
		// TODO Auto-generated method stub
		if(mapCheck.check(ship.loc)==false){
			throw new ShipLocationException("Location error");
		}
		this.ship=ship;
		
		updataMapGrid();
		
		System.out.println("MapModel.update()");
	}

}
