// OvernightPackage class is a subclass of BasePackage and implements RabbitCarrier.
class OvernightPackage extends BasePackage implements RabbitCarrier {
    // Constructor for the OvernightPackage class
    OvernightPackage(String sender, String recipient, double weight) {
        // Calling the constructor of the BasePackage class
        super(sender, recipient, weight);
    }

    // Method to calculate the cost of the package
    double calculateCost() {
        return packageWeight * 1.0;
    }

    // Method to calculate the cost of the package with rabbit express
    public double rabbitExpress() {
        return calculateCost() * 1.2;
    }
}
