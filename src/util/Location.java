package util;

public final class Location {
	public int locaX;
	public int locaY;
	public final static Location nullLoc= new Location(-1,-1);
	
	public Location(){
		locaX=0;
		locaY=0;
	}
	
	public Location(int locaX, int locaY){
		this.locaX=locaX;
		this.locaY=locaY;
	}
}
