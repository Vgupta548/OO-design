package main.ShareRideApp.service.Factory;

import main.ShareRideApp.inventory.InventoryManager;

public class InventoryManagerFactory {

private static InventoryManager manager = new InventoryManager();
	
	public static InventoryManager getInventoryManager(){
		return manager;
	}
}
