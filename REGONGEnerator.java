import java.util.Random;

public class REGONGenerator {
  public static long generateShort() {
    // Generate a random 9-digit REGON number
    Random random = new Random();
    long regon = 100000000L + random.nextInt(900000000);

    // Calculate the checksum
    int checksum = 0;
    for (int i = 0; i < 9; i++) {
      int digit = (int)(regon % 10);
      checksum += digit * (8 - i);
      regon /= 10;
    }

    // Calculate the check digit
    int checkDigit = checksum % 11;
    if (checkDigit == 10) {
      checkDigit = 0;
    }

    // Append the check digit to the REGON number
    return regon * 10 + checkDigit;
  }

  public static long generateLong() {
    // Generate a random 14-digit REGON number
    Random random = new Random();
    long regon = 10000000000000L + random.nextInt(900000000000000L);

    // Calculate the checksum
    int checksum = 0;
    for (int i = 0; i < 14; i++) {
      int digit = (int)(regon % 10);
      if (i < 13) {
        checksum += digit * (14 - i);
      } else {
        checksum += digit;
      }
      regon /= 10;
    }

    // Calculate the check digit
    int checkDigit = checksum % 11;
    if (checkDigit == 10) {
      checkDigit = 0;
    }

    // Append the check digit to the REGON number
    return regon * 10 + checkDigit;
  }

  public static void main(String[] args) {
    // Generate a short REGON number
    long shortRegon = generateShort();
    System.out.println("Short REGON: " + shortRegon);
