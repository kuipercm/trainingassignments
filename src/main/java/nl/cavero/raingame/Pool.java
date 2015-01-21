package nl.cavero.raingame;

public class Pool {
	private final int x;
	private final int y;
	private final int volume;
	
	public Pool(int x, int y, int volume) {
		this.x = x;
		this.y = y;
		this.volume = volume;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getVolume() {
		return volume;
	}
}
