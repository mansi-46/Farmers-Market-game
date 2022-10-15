class Triangle extends IFS {
	
	void move(int r) {
		switch(r) {
			case 0:
				this.x = 0.5 * this.x;
				this.y = 0.5 * this.y + 4;
				break;
			case 1:
				this.x = 0.5 * this.x - 0.5;
				this.y = 0.5 * this.y + 3;
				break;
			case 2:
				this.x = 0.5 * this.x + 0.5;
				this.y = 0.5 * this.y + 3;
				break;
		}
	}
	
	public static void main(String[] args) {
		
		copies = 3;
		
		Triangle trey = new Triangle();
		trey.setup(trey, "Sierpinski Triangle");
	}
}
