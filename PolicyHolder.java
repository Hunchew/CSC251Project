/**
 * policyholder associated with an insurance policy.
 */
public class PolicyHolder {
    // Fields
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * No-argument constructor that initializes a default PolicyHolder.
     */
    public PolicyHolder() {
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }

    /**
     * Constructor that initializes a PolicyHolder with specified values.
     * @param firstName the first name of the policyholder
     * @param lastName the last name of the policyholder
     * @param age the age of the policyholder
     * @param smokingStatus the smoking status ("smoker" or "non-smoker")
     * @param height the height in inches
     * @param weight the weight in pounds
     */
    public PolicyHolder(String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Getters / Setters

    /**
     * Gets the first name of the policyholder.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the policyholder.
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the policyholder.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the policyholder.
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the age of the policyholder.
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the policyholder.
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the smoking status of the policyholder.
     * @return the smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Sets the smoking status of the policyholder.
     * @param smokingStatus the smoking status to set ("smoker" or "non-smoker")
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Get the height of the policyholder in inches.
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * Dets the height of the policyholder.
     * @param height the height to set in inches
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Gets the weight of the policyholder in pounds.
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the policyholder.
     * @param weight the weight to set in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Additional Method

    /**
     * Calculates the BMI of the policyholder.
     * @return the BMI value
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /**
     * Returns a string representation of the policyholder.
     * @return the policyholder's information as a string
     */
    @Override
    public String toString() {
        return String.format(
            "Policyholder's First Name: %s\n" +
            "Policyholder's Last Name: %s\n" +
            "Policyholder's Age: %d\n" +
            "Policyholder's Smoking Status (smoker/non-smoker): %s\n" +
            "Policyholder's Height: %.1f inches\n" +
            "Policyholder's Weight: %.1f pounds\n" +
            "Policyholder's BMI: %.2f\n",
            firstName, lastName, age, smokingStatus, height, weight, calculateBMI()
        );
    }
}

