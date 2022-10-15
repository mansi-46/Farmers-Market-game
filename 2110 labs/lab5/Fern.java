class Fern extends IFS {
	
	void move(int r) {
		switch(r) {
			case 0:
				this.x = 0.0;
				this.y = 0.2 * this.y;
				break;
			case 1:
				this.x = 0.85 * this.x + 0.04 * this.y;
				this.y = -0.04 * this.x + 0.85 * this.y + 1.60;
				break;
			case 2:
				this.x = 0.20 * this.x - 0.26 * this.y;
				this.y = 0.23 * this.x + 0.22 * this.y + 1.60;
				break;
			case 3:
				this.x = -0.15 * this.x + 0.28 * this.y;
				this.y = 0.26 * this.x + 0.24 * this.y + 0.44;
		}
	}


	public static void main(String[] args) {
		
		copies = 4;
		
		Fern fernie = new Fern();
		fernie.setup(fernie, "Barnsley Fern");
	}
}
