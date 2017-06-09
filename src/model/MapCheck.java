package model;

import constant.GRIDTYPE;
import util.Location;

public class MapCheck {
	private int maxX;
	private int maxY;
	private int[][] mapGrid;
	
	public MapCheck(int maxX,int maxY,int [][] mapGrid){
		this.maxX=maxX;
		this.maxY=maxY;
		this.mapGrid=mapGrid;
	}
	
	public boolean initCheck(Location[] locs){
		
		for(int i=0;i<locs.length;i++){
			if(locs[i].locaX<0||locs[i].locaX>maxX-1||locs[i].locaY<0||locs[i].locaY>maxY-1){
				return false;
			}
		}
		
		for(int i=0;i<locs.length;i++){
			if(mapGrid[locs[i].locaX][locs[i].locaY]!=GRIDTYPE.NO_SHIP){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean hurtCheck(Location loc)
	{
		if(loc.locaX<0||loc.locaX>maxX-1||loc.locaY<0||loc.locaY>maxY-1){
			return false;
		}
		
		if(mapGrid[loc.locaX][loc.locaY]==GRIDTYPE.DEAD_SHIP){
			return false;
		}
		else if(mapGrid[loc.locaX][loc.locaY]==GRIDTYPE.HURT_GRID){
			return false;
		}
		
		return true;
	}
}
