public class Vehicle
{
    // Public data members
    public String brandName;
    public String modelName;
    public String colour;
    public double price;
    public int passengerCapacity;
    public char fuelType;

    // Private data members
    private String registrationNumber;
    private int manufactureYear;

    // Default Constructor
    public Vehicle()
    {
        brandName = "Toyota";
        modelName = "Corolla";
        colour = "White";
        price = 1500000.00;
        passengerCapacity = 5;
        fuelType = 'p';
        registrationNumber = "MH12AB1234";
        manufactureYear = 2023;
    }

    // Parameterized Constructor
    public Vehicle(String brandName, String modelName, double price, char fuelType)
    {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.fuelType = fuelType;
        this.colour = "Black";
        this.passengerCapacity = 5;
        this.registrationNumber = "Unknown";
        this.manufactureYear = 2024;
    }

    // Copy Constructor
    public Vehicle(Vehicle v)
    {
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.colour = v.colour;
        this.price = v.price;
        this.passengerCapacity = v.passengerCapacity;
        this.fuelType = v.fuelType;
        this.registrationNumber = v.registrationNumber;
        this.manufactureYear = v.manufactureYear;
    }

    // Getters and Setters
    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber)
    {
        this.registrationNumber = registrationNumber;
    }

    public int getManufactureYear()
    {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear)
    {
        this.manufactureYear = manufactureYear;
    }

    // Methods
    public void start()
    {
        System.out.println(brandName + " " + modelName + " has started successfully.");
    }

    public void stop()
    {
        System.out.println(brandName + " " + modelName + " has stopped. Speed is now 0 km/h.");
    }

    public void drive()
    {
        System.out.println(brandName + " " + modelName + " is now being driven.");
    }

    public float calcMileage(float fuelConsumed, float distanceTraveled)
    {
        float baseMileage = distanceTraveled / fuelConsumed;
        
        if (fuelType == 'd')
        {
            return baseMileage - (baseMileage * 0.1f);
        }
        else if (fuelType == 'p')
        {
            return baseMileage;
        }
        else
        {
            return baseMileage * 1.2f;
        }
    }

    public float changeSpeed(float currentSpeed)
    {
        if (currentSpeed < 30)
        {
            return currentSpeed + 25;
        }
        else
        {
            return currentSpeed - 15;
        }
    }
}