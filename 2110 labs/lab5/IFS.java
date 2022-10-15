import java.awt.*;
import java.util.Random;

class IFS extends Fractal {
	static int copies;
	
	void move(int r) {}
	
	public void paint(Graphics g) {
		
		this.x = 0.0;
		this.y = 0.0;
		Random random = new Random();
		
		for (int i = 0; i < 1000000; i++) {
			
			int r = random.nextInt(this.copies);
			move(r);
			g.drawLine((int) (80 * x + 500.5), (int) (-80 * y + 900.5), (int) (80 * x + 500.5), (int) (-80 * y + 900.5)); 
		}
	}
}
