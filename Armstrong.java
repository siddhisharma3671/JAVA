public class ArmstrongNumbers {
    public static void main(String[] args) {

        System.out.println("Armstrong numbers from 1 to 1000:");

        for (int num = 1; num <= 1000; num++) {

            int original = num;
            int sum = 0;
            int digits = String.valueOf(num).length();

            while (num > 0) {
                int digit = num % 10;
                sum += Math.pow(digit, digits);
                num = num / 10;
            }

            if (sum == original) {
                System.out.println(original);
            }

            num = original;  // restore num for the for loop
        }
    }
}
