package Question1;

import java.util.Scanner;

public class VehicleApp
{
    public static void main(String[] args)
    {
        Vehicle aston = new AstonMartin(4, 2);
        Vehicle Ferr = new Ferrari(4,2);
        Vehicle scania = new Scania();
        Vehicle man = new Man();
        int uoption;

        while(true)
        {
            uoption = displayOptions();
            switch (uoption)
            {
                case 1:
                    aston.drive();
                    aston.steer(uoption);
                    aston.stop();
                    break;

                case 2:
                    Ferr.drive();
                    Ferr.steer(uoption);
                    Ferr.stop();
                    break;

                case 3:
                    man.drive();
                    man.steer(uoption);
                    man.stop();
                    break;

                case 4:
                    scania.drive();
                    scania.steer(uoption);
                    scania.stop();
                    break;

                default:
                    System.out.println("Entered Invalid Option, Please Select Again.");
                    displayOptions();
            }
        }

    }

    private static int displayOptions()
    {
        int temp;
        System.out.println("\nSelect your choice of vehicle");
        System.out.println("1. Aston Martin:");
        System.out.println("2. Ferrari:");
        System.out.println("3. Man:");
        System.out.println("4. Scania:");
        System.out.println("\nSelect an Option");
        Scanner uoption = new Scanner(System.in);
        temp = uoption.nextInt();
        return temp;
    }
}
