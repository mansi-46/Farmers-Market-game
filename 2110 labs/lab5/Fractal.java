import java.awt.*;
import javax.swing.*;

class Fractal extends Canvas {
	double x, y;

	void setup(Canvas canvas, String title) {
		
		JFrame frame = new JFrame(title);
		canvas.setSize(1000, 1000);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);

	}
}
