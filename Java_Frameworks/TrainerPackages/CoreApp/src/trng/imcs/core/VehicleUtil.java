package trng.imcs.core;

public class VehicleUtil {
	public static void useVehicle(int doors, String name, int speed) {
		Vehicle vehicle = new Vehicle();
		vehicle.setDoors(doors);
		vehicle.setName(name);
		vehicle.setSpeed(speed);
		vehicle.setState(false);
		
		System.out.println(vehicle);

		vehicle.increaseSpeed(25);
		System.out.println("Speed: " + vehicle.getSpeed());
		
		vehicle.increaseSpeed(100);
		System.out.println("Speed: " + vehicle.getSpeed());

		vehicle.increaseSpeed(100);
		System.out.println("Speed: " + vehicle.getSpeed());
	}

}
