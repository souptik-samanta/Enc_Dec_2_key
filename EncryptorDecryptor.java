import java.util.Scanner;

public class EncryptorDecryptor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a String");
        System.out.println("2. Decrypt an Array");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter the string to be encrypted:");
            scanner.nextLine();
            String input = scanner.nextLine();

            System.out.println("Enter Key 1:");
            int key1 = scanner.nextInt();

            System.out.println("Enter Key 2:");
            int key2 = scanner.nextInt();

            int[] encryptedArray = encrypt(input, key1, key2);

            System.out.println("Encrypted Array:");
            for (int value : encryptedArray) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else if (choice == 2) {
            System.out.println("Enter Key 1:");
            int key1 = scanner.nextInt();

            System.out.println("Enter Key 2:");
            int key2 = scanner.nextInt();

            System.out.println("Enter the size of the encrypted array:");
            int size = scanner.nextInt();
            int[] encryptedArray = new int[size];

            System.out.println("Enter the encrypted array elements:");
            for (int i = 0; i < size; i++) {
                encryptedArray[i] = scanner.nextInt();
            }

            String decryptedString = decrypt(encryptedArray, key1, key2);
            System.out.println("Decrypted String:");
            System.out.println(decryptedString);
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public static int[] encrypt(String input, int key1, int key2) {
        int[] asciiArray = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            int asciiValue = input.charAt(i);
            asciiValue *= key1;
            if (isPrime(asciiValue)) {
                asciiValue *= key2;
            }
            asciiArray[i] = asciiValue;
        }

        return asciiArray;
    }

    public static String decrypt(int[] encryptedArray, int key1, int key2) {
        StringBuilder decrypted = new StringBuilder();

        for (int value : encryptedArray) {
            int asciiValue = value;
            if (asciiValue % key2 == 0) {
                asciiValue /= key2;
            }
            asciiValue /= key1;
            decrypted.append((char) asciiValue);
        }

        return decrypted.toString();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

