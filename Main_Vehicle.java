public class Main
{
    public static void main(String[] args)
    {
        System.out.println("=== Vehicle Management System ===\n");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setRegistrationNumber("DL01XY5678");

        Vehicle vehicle2 = new Vehicle("Honda", "City", 1200000.00, 'p');
        vehicle2.setRegistrationNumber("MH02CD9876");

        Vehicle vehicle3 = new Vehicle("Mahindra", "Scorpio", 1800000.00, 'd');
        vehicle3.setRegistrationNumber("KA03EF4567");

        Vehicle vehicle4 = new Vehicle(vehicle2);
        vehicle4.brandName = "Hyundai";
        vehicle4.modelName = "Verna";
        vehicle4.price = 1400000.00;

        Vehicle vehicle5 = new Vehicle();
        vehicle5.brandName = "Maruti";
        vehicle5.modelName = "Swift";
        vehicle5.price = 800000.00;

        System.out.println("--- Testing Methods ---");
        vehicle1.start();
        vehicle1.drive();
        vehicle1.stop();
        System.out.println();

        Vehicle[] vehicleFleet = {vehicle1, vehicle2, vehicle3, vehicle4, vehicle5};

        System.out.println("Brand Name\tModel Name\tPrice\t\t\tMileage (km/l)");
        System.out.println("========================================================================");

        for (Vehicle v : vehicleFleet)
        {
            printVehicleDetails(v);
        }
    }

    public static void printVehicleDetails(Vehicle v)
    {
        float mileage = v.calcMileage(5.0f, 100.0f);
        System.out.printf("%-15s\t%-15s\t%-15.2f\t%.2f\n", 
            v.brandName, v.modelName, v.price, mileage);
    }
}