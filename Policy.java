/**
 * Represents an insurance policy with details about the policyholder.
 */
public class Policy {
    // Fields
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    // Static field to track the number of Policy objects created
    private static int policyCount = 0;

    /**
     * No-argument constructor
     */
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyHolder = new PolicyHolder();
        policyCount++;
    }

    /**
     * Constructor that initializes a Policy with specified values.
     * @param policyNumber the policy number
     * @param providerName the name of the insurance provider
     * @param policyHolder the PolicyHolder object associated with the policy
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(
            policyHolder.getFirstName(),
            policyHolder.getLastName(),
            policyHolder.getAge(),
            policyHolder.getSmokingStatus(),
            policyHolder.getHeight(),
            policyHolder.getWeight()
        );
        policyCount++;
    }

    // Getters and Setters

    /**
     * Gets the policy number.
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the policy number.
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets the provider name.
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Sets the provider name.
     * @param providerName the provider name to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Gets the PolicyHolder associated with this policy.
     * @return the policyHolder
     */
    public PolicyHolder getPolicyHolder() {
        // Return a deep copy to prevent security issues
        return new PolicyHolder(
            policyHolder.getFirstName(),
            policyHolder.getLastName(),
            policyHolder.getAge(),
            policyHolder.getSmokingStatus(),
            policyHolder.getHeight(),
            policyHolder.getWeight()
        );
    }

    /**
     * Sets the PolicyHolder associated with this policy.
     * @param policyHolder the policyHolder to set
     */
    public void setPolicyHolder(PolicyHolder policyHolder) {
        // Create a deep copy to prevent security issues
        this.policyHolder = new PolicyHolder(
            policyHolder.getFirstName(),
            policyHolder.getLastName(),
            policyHolder.getAge(),
            policyHolder.getSmokingStatus(),
            policyHolder.getHeight(),
            policyHolder.getWeight()
        );
    }

    // Static Methods

    /**
     * Gets the total number of Policy objects created.
     * @return the policy count
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    // Additional Methods

    /**
     * Calculates the price of the policy based on the policyholder's information.
     * @return the policy price
     */
    public double calculatePolicyPrice() {
        final double BASE_PRICE = 600.0;
        final double AGE_FEE = 75.0;
        final double SMOKER_FEE = 100.0;
        final double BMI_FEE = 20.0;
        final double BMI_THRESHOLD = 35.0;

        double price = BASE_PRICE;

        if (policyHolder.getAge() > 50) {
            price += AGE_FEE;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += SMOKER_FEE;
        }

        if (policyHolder.calculateBMI() > BMI_THRESHOLD) {
            price += (policyHolder.calculateBMI() - BMI_THRESHOLD) * BMI_FEE;
        }

        return price;
    }

    /**
     * Returns a string representation of the policy.
     * @return the policy information as a string
     */
    @Override
    public String toString() {
        return String.format(
            "Policy Number: %d\n" +
            "Provider Name: %s\n" +
            "%s" + // PolicyHolder's toString()
            "Policy Price: $%.2f\n",
            policyNumber, providerName, policyHolder.toString(), calculatePolicyPrice()
        );
    }
}
