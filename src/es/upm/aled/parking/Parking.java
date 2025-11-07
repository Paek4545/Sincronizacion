package es.upm.aled.parking;

public class Parking {
	
	private final int capacity;
	private int cars;
	
	public Parking(int capacity) {
		this.capacity = capacity;
		this.cars = 0; // Lo que vale inicialmente cars
	}
	
	public synchronized void enter(int plate) {
		// Si cars < capacidad, le dejo pasar
		// Si no, a esperar
		// Una vez entre, aumentar cars en 1
		try {	
		while (cars >= capacity) {
			System.out.println("Car " + plate + " is waiting to enter.");
				wait(); // Espero en la entrada
				// He conseguido entrar
		}
			System.out.println("Car " + plate + " has managed to enter.");
				cars++;
		} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	
	
	public synchronized void exit(int plate) {
		// Reducir cars en 1
		cars--;
		// Una vez que sale notificamos
		System.out.println("Car " + plate + " has exited. ");
		notify(); // Despierta a un coche que espere al azar
		
	}
}
