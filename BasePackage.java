// BasePackage class is the parent class for the OvernightPackage, TwoDayPackage, PriorityPackage, and FirstClassPackage classes. 
abstract class BasePackage {
    // Attributes
    String senderName;
    String recipientName;
    double packageWeight;

    // Constructor for the BasePackage class
    BasePackage(String sender, String recipient, double weight) {
        this.senderName = sender;
        this.recipientName = recipient;
        this.packageWeight = weight;
    }

    // Getters
    public String getSenderName() {
        return this.senderName;
    }
    public String getRecipientName() {
        return this.recipientName;
    }

    // Abstract method to calculate the cost of the package
    abstract double calculateCost();
}