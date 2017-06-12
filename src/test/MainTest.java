package test;

import java.util.Scanner;

import constant.ATTACTORDER;
import constant.SHIPTYPE;
import model.GameProcess;
import model.MapModel;
import model.ShipModel;
import util.Location;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*这是测试创建船只的部分
		ShipModel shipModel=new ShipModel();
		
		MapModel mapModel=new MapModel();
		mapModel.initMapGrid(100, 100);
		
		shipModel.registerObserver(mapModel);
		
		Location []locs=new Location[1];
		locs[0]=new Location(1,1);
		
		shipModel.initShip(SHIPTYPE.TINY_SHIP,locs);
		
		ShipModel shipModel2=new ShipModel();
		shipModel2.registerObserver(mapModel);
		
		Location []locs2=new Location[2];
		locs2[0]=new Location(0,1);
		locs2[1]=new Location(1,1);
		shipModel2.initShip(SHIPTYPE.SMALL_SHIP, locs2);
		
		
		//shipModel.hurtShip();
		 * 
		 */
		/*
		ShipModel shipModel=new ShipModel();
		Location []locs=new Location[2];
		locs[0]=new Location(2, 2);
		locs[1]=new Location(2, 3);
		//shipModel.initShip(SHIPTYPE.SMALL_SHIP, locs);
		
		MapModel mapModel=new MapModel();
		mapModel.initMapGrid(100, 100);
		
		shipModel.registerObserver(mapModel);
		
		shipModel.initShip(SHIPTYPE.SMALL_SHIP, locs);
		
		shipModel.hurtShip(new Location(2,2));
		shipModel.hurtShip(new Location(2,2));
		*/
		
		GameProcess gameProcess=GameProcess.getGameProcess();
		gameProcess.gameStart();
		
		ShipModel[] firstShips=new ShipModel[1];
		firstShips[0]=new ShipModel();
		Location []locs=new Location[2];
		locs[0]=new Location(2, 2);
		locs[1]=new Location(2, 3);
		firstShips[0].initShip(SHIPTYPE.SMALL_SHIP, locs);
		
		MapModel firstMap=new MapModel();
		firstMap.initMapGrid(100, 100);
		
		
		
		ShipModel[] secondShips=new ShipModel[1];
		secondShips[0]=new ShipModel();
		locs=new Location[2];
		locs[0]=new Location(3, 3);
		locs[1]=new Location(3, 4);
		secondShips[0].initShip(SHIPTYPE.SMALL_SHIP, locs);
		
		MapModel secondMap=new MapModel();
		secondMap.initMapGrid(100, 100);
		
		gameProcess.gameReady(firstShips, secondShips, firstMap, secondMap);
		
		gameProcess.chooseAttactOrder(ATTACTORDER.FIRST_ATTACT);
		
		int x,y;
		do{
			System.out.println("Input the location:");
			Scanner scanner=new Scanner(System.in);
			x=scanner.nextInt();
			y=scanner.nextInt();
		}while(gameProcess.nextAttact(new Location(x,y))!=0);
	}

}
