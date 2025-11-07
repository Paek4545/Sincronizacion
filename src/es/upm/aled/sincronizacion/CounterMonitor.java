package es.upm.aled.sincronizacion;

// This is Thread.Safe
public class CounterMonitor extends Counter {
	
	@Override
	public synchronized void increase() { // synchronized --> cuando alguien utiliza este método nadie más podrá utilizarlo
		count++; // Tampoco es atómico
	}

	@Override
	public  synchronized int getCount() {
		return count;
		
	}
	@Override
	public synchronized void setCount(int count) {
		this.count = count;
	}
}
