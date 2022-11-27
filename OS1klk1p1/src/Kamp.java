
public class Kamp {
	private int pecurke = 0;
	private int drva = 0;
	
	

	synchronized public void donesiPecurke(int koliko) throws InterruptedException {
		while(drva < pecurke + koliko) {
			wait();
		}
		pecurke += koliko;

		stampajPoruku("je dodao pecurke");
	}

	synchronized public void donesiDrva(int koliko) {
		drva += koliko;	
		//Posto mozemo dobiti vise drva od jednom
		notifyAll();
		stampajPoruku("je dodao drva");
	}
	
	synchronized public void ispis() {
		System.out.println("Trenutno stanje u kampu je: Pecurke: " + pecurke + ",  drva: " + drva);
	}
	
	
	synchronized private void stampajPoruku(String poruka) {
		System.out.printf("%-12s %-20s Stanje u kampu: pecurke:%3d  drva:%3d %n",
				Thread.currentThread().getName(),
				poruka,
				pecurke,				
				drva);
	}
	
}
