package es.upm.aled.buffer;

public class Test {
	
	public static void main(String[] args) {
		Buffer<Integer> buf = new Buffer<Integer>();
		for (int i = 0; i< 10; i++) {
			Productor p = new Productor(i, i*5, buf); // 10 productores
			Consumidor c = new Consumidor(i, i*3, buf); // 10 consumidores
			
			p.start();
			c.start();
			
		}
	}
}
