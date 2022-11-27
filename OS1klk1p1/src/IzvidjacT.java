public class IzvidjacT extends Thread {

	Suma suma;
	Kamp kamp;

	public IzvidjacT(Suma suma, Kamp kamp) {
		this.kamp = kamp;
		this.suma = suma;
	}

	@Override
	public void run() {

		try {

			for (int i = 0; i < 20 && !interrupted(); i++) {

				int precurke = suma.traziPecurke();
				if (!interrupted()) {
					kamp.donesiPecurke(precurke);
					//System.out.println(Thread.currentThread().getName() + " je trazio pecurke " + i + "-ti put ");
				}

			} // for

		} catch (Exception e) {
			// Prekidamo rad
		}

	}// run

}
