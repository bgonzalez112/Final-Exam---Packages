// FirstClassPackage class is a subclass of the BasePackage class.
class FirstClassPackage extends BasePackage {
    // Constructor for the FirstClassPackage class
    FirstClassPackage(String sender, String recipient, double weight) {
        // Calling the constructor of the BasePackage class
        super(sender, recipient, weight);
    }

    // Method to calculate the cost of the package
    double calculateCost() {
        return packageWeight * 0.5;
    }
}