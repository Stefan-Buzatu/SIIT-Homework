package Vehicle;

public class VWPassat extends Volkswagen {


    public VWPassat(int fuelTankSize, String fuelType, int gears, double consumptionPer100Km) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km);
    }

    public VWPassat(double availableFuel, String chassisNumber) {
        super(60, "Diesel", 6, 3.0);
        this.setInitialAvailableFuel(availableFuel);
        this.setAvailableFuel(availableFuel);
        this.setChassisNumber(chassisNumber);
        this.setTireSize(15);
    }

    @Override
    public void start() {
        this.setAverageFuelConsumption(0);
        System.out.println("Volkswagen Passat has started");
    }

    @Override
    public void stop() {
        this.setAverageFuelConsumption(this.getInitialAvailableFuel() - this.getAvailableFuel());
        System.out.println("VWPassat has stopped");
    }

    @Override
    public void drive(double nKms) {
        if (this.getCurrentGear() > 6 || this.getCurrentGear() < 1) {
            this.setCurrentGear(1);
            this.setAverageFuelConsumption(this.getConsumptionPer100Km());
        }
        double auxiliar = this.getAvailableFuel();
        auxiliar = auxiliar - this.getAverageFuelConsumption() * nKms;
        this.setAvailableFuel(auxiliar);
        System.out.println("Driving VWPassat in " + this.getCurrentGear());

    }

    @Override
    public void shiftGear(int currentGear) {
        this.setCurrentGear(currentGear);
        switch (currentGear) {
            case 2: {
                this.setAverageFuelConsumption(2.9);
                this.setCurrentGear(2);
                break;
            }
            case 3: {
                this.setAverageFuelConsumption(2.8);
                this.setCurrentGear(3);
                break;
            }
            case 4: {
                this.setAverageFuelConsumption(2.7);
                this.setCurrentGear(4);
                break;
            }
            case 5: {
                this.setAverageFuelConsumption(2.6);
                this.setCurrentGear(5);
                break;
            }
            case 6: {
                this.setAverageFuelConsumption(2.5);
                this.setCurrentGear(6);
                break;
            }
            default: {
                this.setAverageFuelConsumption(this.getConsumptionPer100Km());
                this.setCurrentGear(1);
                break;
            }
        }
    }
}
