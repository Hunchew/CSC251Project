import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Demo {

    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>(); // List to store policies
        int smokerCount = 0;
        int nonSmokerCount = 0;

        // Load data from file
        try {
            File file = new File("PolicyInformation.txt");
            Scanner scanner = new Scanner(file);

            // Read data line by line for each Policy
            while (scanner.hasNext()) {
                int policyNumber = Integer.parseInt(scanner.nextLine());
                String providerName = scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                int age = Integer.parseInt(scanner.nextLine());
                String smokingStatus = scanner.nextLine();
                double height = Double.parseDouble(scanner.nextLine());
                double weight = Double.parseDouble(scanner.nextLine());

                // Create PolicyHolder and Policy objects
                PolicyHolder policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
                Policy policy = new Policy(policyNumber, providerName, policyHolder);

                // Add Policy to the list
                policies.add(policy);

                // Count smokers and non-smokers
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // Display each policy using toString
        for (Policy policy : policies) {
            System.out.println(policy.toString());
            System.out.println("Policy Price: $" + calculatePolicyPrice(policy));
            System.out.println();
        }

        // Display summary information
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }

    /**
     * Calculates the price of a policy based on the policyholder's smoking status and BMI.
     * @param policy the Policy for which the price is calculated
     * @return the calculated policy price
     */
    public static double calculatePolicyPrice(Policy policy) {
        PolicyHolder holder = policy.getPolicyHolder();
        double basePrice = 600.0;
        if (holder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            basePrice += 100;
        }
        double bmi = holder.calculateBMI();
        if (bmi > 35) {
            basePrice += 75;
        }
        return basePrice;
    }
}
