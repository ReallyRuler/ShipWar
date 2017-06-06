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
	
	public boolean check(Location[] locs){
		for(int i=0;i<locs.length;i++){
			if(mapGrid[locs[i].locaX][locs[i].locaY]!=GRIDTYPE.NO_SHIP){
				return false;
			}
		}
		return true;
	}
}
