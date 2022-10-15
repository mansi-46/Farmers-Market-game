import java.awt.*;

class SquareAndAdd extends Fractal {
	static double c_x, c_y;
	
	void setCs() {}
	
	public void paint(Graphics g) {

		for (int i = 0; i < 1000; i++) {

			for (int j = 0; j < 1000; j++) {
				
				g.setColor(Color.black);
				g.drawLine(i, j, i, j);
				
				this.x = i;
				this.x = (this.x - 500) / 200;
				this.y = j;
				this.y = (this.y - 500) / 200;
				
				setCs();
				
				for (int k = 0; k < 256; k++) {
					
					if (this.x * this.x + this.y * this.y > 4) {
						g.setColor(new Color(255 - k, 255 - k, 255 - k));
						g.drawLine(i, j, i, j);
						break;
					}
					
					double temp_x = this.x * this.x - this.y * this.y + this.c_x;
					double temp_y = 2 * this.x * this.y + this.c_y;
					this.x = temp_x;
					this.y = temp_y;
				}
			}
		}
	}
}
