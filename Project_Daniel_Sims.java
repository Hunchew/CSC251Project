public class Project_Daniel_Sims {
    public static void main(String[] args) {
        // Create a Policy object with sample data
        Policy policy = new Policy(
            1234, "State Farm", "John", "Doe", 24, "non-smoker", 62.0, 250.5
        );

        // Output the policy details
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder’s First Name: " + policy.getFirstName());
        System.out.println("Policyholder’s Last Name: " + policy.getLastName());
        System.out.println("Policyholder’s Age: " + policy.getAge());
        System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder’s Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder’s Weight: " + policy.getWeight() + " pounds");
        System.out.println("Policyholder’s BMI: " + policy.calculateBMI());
        System.out.println("Policy Price: $" + policy.calculatePolicyPrice());
    }
}
