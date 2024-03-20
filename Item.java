
public class Item extends AbstractItem{
	protected double point;
	protected char initial;
	protected String oyuncu;

	public Item() {
		
	}

	@Override
	public void move(String destination) throws Exception {
		
		
	}

	public double getPoint() {
		return this.point;
	}

	public char getInitial() {
		return this.initial;
	}

	public void setInitial(char initial) {
		this.initial = initial;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getOyuncu() {
		return this.oyuncu;
	}

}
