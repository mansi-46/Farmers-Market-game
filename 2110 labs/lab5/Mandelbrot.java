class Mandelbrot extends SquareAndAdd {

	void setCs() {
	
		this.c_x = this.x;
		this.c_y = this.y;
	}
	
	public static void main(String[] args) {
	
		Mandelbrot mandy = new Mandelbrot();
		mandy.setup(mandy, "Mandelbrot Set");
	}
}
