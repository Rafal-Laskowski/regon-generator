import java.util.Random;

public class REGONGenerator {
    public static String generateShort() {
        Random random = new Random();

        // Generate a random 5-digit number for the first half of the REGON
        String firstHalf = String.format("%05d", random.nextInt(100000));

        // Generate a random 3-digit number for the second half of the REGON
        String secondHalf = String.format("%03d", random.nextInt(1000));

        // Concatenate the two halves to form the raw REGON
        String rawRegon = firstHalf + secondHalf;

        // Calculate the checksum
        int[] weights = {8, 9, 2, 3, 4, 5, 6, 7};
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * Character.getNumericValue(rawRegon.charAt(i));
        }

        // Calculate the check digit
        int checkDigit = sum % 11 % 10;

        // Return the REGON with the check digit appended
        return rawRegon + checkDigit;
    }

    public static String generateLong() {
        // Generate a random 9-digit REGON number
        String firstHalf = generateShort();

        // Generate a random 4-digit number for the second half of the REGON
        Random random = new Random();
        String secondHalf = String.format("%04d", random.nextInt(10000));

        // Concatenate the two halves to form the raw REGON
        String rawRegon = firstHalf + secondHalf;

        // Calculate the checksum
        int[] weights = {2, 4, 8, 5, 0, 9, 7, 3, 6, 1, 2, 4, 8};
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * Character.getNumericValue(rawRegon.charAt(i));
        }

        // Calculate the check digit
        int checkDigit = sum % 11 % 10;

        // Return the REGON with the check digit appended
        return rawRegon + checkDigit;
    }

    public static void main(String[] args) {
        // Generate a short REGON number
        String shortRegon = generateShort();
        System.out.println("SHORT REGON: " + shortRegon);

        String longRegon = generateLong();
        System.out.println("LONG REGON: " + longRegon);
    }
}
