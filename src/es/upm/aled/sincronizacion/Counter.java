package es.upm.aled.sincronizacion;

public class Counter {
	protected int count = 0;
	
	// Región crítica
	public int getCount() {
		return count;
		
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void increase() {
		
		count++; // Tampoco es atómico
	}
	
}
