package es.upm.aled.sincronizacion;

public class IncreaserGetSet extends Increaser {
	
	public IncreaserGetSet(Counter counter) {
		super(counter);
	}

	// Incrementa el contador 1.000.000 de veces
	@Override
	public void run() { // Al run no se le puede poner el synchronized
		for (int i = 0; i < 1000000; i++) {
			// START Región crítica
			synchronized(counter) { // Esta línea aisla la región crítica (un trozo de código no el método)
				int count = counter.getCount();
				count++;
				counter.setCount(count);
				// END Región crítica	
			}
			
		}
	}
}
