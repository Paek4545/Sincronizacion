package es.upm.aled.buffer;

public class Buffer<Tipo> {
	
	private Tipo dato;
	
	
	public synchronized void store(int id, Tipo dato) { // Guardar
		// Si el buffer está vacío
		
		try {
			while(this.dato != null) {
				System.out.println("Producto " + id + " está esperando");
				wait();
		} 
			this.dato = dato;
			System.out.println("Productor " + id + " ha producido el dato " + dato);
			notifyAll();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	
	public synchronized Tipo retrieve(int id) { // Recoger
		Tipo aDevolver = null;
		// Si el buffer está lleno
		try {
		while (this.dato == null) {
			System.out.println("Consumidor " + id + " está esperando");
			wait();
		}
		aDevolver = dato;
		this.dato = null; // Se "consume" el dato
		System.out.println("Consumidor " + id + " ha consumido " + aDevolver);
		notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return aDevolver;
	}
	
}
