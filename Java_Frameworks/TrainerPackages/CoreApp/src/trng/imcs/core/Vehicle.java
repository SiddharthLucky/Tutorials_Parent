package trng.imcs.core;

public class Vehicle {

	private String name;
	private int speed;
	private int doors;
	private boolean state;
	public static final int MAX_SPEED = 200;
	
	public boolean increaseSpeed(int speed) {
		if ((this.speed + speed) < MAX_SPEED) {
			this.speed = this.speed + speed;
			return true;
		}
		
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", speed=" + speed + ", doors=" + doors + ", state=" + state + "]";
	}

	public static int getMaxSpeed() {
//		speed = 10;
		return MAX_SPEED;
	}
}
