package Start;

import Business.BaseProduct;
import Business.CompositeProduct;
import Business.Restaurant;
import Data.FileWriterClass;
import Presentation.Admin.Controller_Admin;
import Presentation.Admin.Model_Admin;
import Presentation.Admin.View_Admin;
import Presentation.Chef;
import Presentation.Waiter.Controller_Waiter;
import Presentation.Waiter.Model_Waiter;
import Presentation.Waiter.View_Waiter;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.Logger;



public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

//		Restaurant myRestaurant=new Restaurant();
//
//		BaseProduct icre =new BaseProduct("Icre", 2);
//		myRestaurant.addToMenu(icre);
//		BaseProduct paine =new BaseProduct("Paine",1);
//		myRestaurant.addToMenu(paine);
//
//		CompositeProduct cevaBun =new CompositeProduct("Ceva bun (C)");
//		cevaBun.addComponent(icre);
//		cevaBun.addComponent(paine);
//		myRestaurant.addToMenu(cevaBun);
//
//		BaseProduct mustar =new BaseProduct("mustar",1000);
//		myRestaurant.addToMenu(mustar);
//		BaseProduct pateu =new BaseProduct("Pateu",3);
//		myRestaurant.addToMenu(pateu);
//		BaseProduct supa =new BaseProduct("Supa la plic",1);
//		myRestaurant.addToMenu(supa);
//
//		CompositeProduct paineCuMustar =new CompositeProduct("Paine cu mustar (C)");
//		paineCuMustar.addComponent(paine);
//		paineCuMustar.addComponent(mustar);
//		myRestaurant.addToMenu(paineCuMustar);
//
//
//		try {
//			FileOutputStream fileOut =
//					new FileOutputStream("restaurant.ser");
//			ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			out.writeObject(myRestaurant);
//			out.close();
//			fileOut.close();
//			System.out.printf("Serialized data is saved in restaurant.ser");
//		} catch (IOException i) {
//			i.printStackTrace();
//		}





		Restaurant myRestaurant = null;
		try {
			FileInputStream fileIn = new FileInputStream("restaurant.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			myRestaurant = (Restaurant) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Restaurant class not found");
			c.printStackTrace();
			return;
		}

		Chef myChef=new Chef();
		myRestaurant.setChef(myChef);

		Model_Waiter mw = new Model_Waiter(myRestaurant);
		View_Waiter vw = new View_Waiter(mw);
		new Controller_Waiter(vw, mw);

		Model_Admin m = new Model_Admin(myRestaurant);
		View_Admin v = new View_Admin(m);
		new Controller_Admin(v, m,vw);




	}

}
