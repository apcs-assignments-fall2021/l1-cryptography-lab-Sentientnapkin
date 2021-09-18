import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String encrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'A' && ch <= 'W' || ch >= 'a' && ch <= 'w')
                encrypted += (char) (ch + 3);
            else if (ch >= 'X' && ch <= 'Z' || ch >= 'x' && ch <= 'z')
                encrypted += (char) (ch - 23);
            else encrypted += ch;
        }
        message = encrypted;
        return message;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String decrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'D' && ch <= 'Z' || ch >= 'd' && ch <= 'z')
                decrypted += (char) (ch - 3);
            else if (ch >= 'A' && ch <= 'C' || ch >= 'a' && ch <= 'c')
                decrypted += (char) (ch + 23);
            else decrypted += ch;
        }
        message = decrypted;
        return message;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String encrypted = "";
        if (key == 0) return message;
        if (key >= 26) key %= 26;
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= 'A' && ch <= (char) ('Z' - key) || ch >= 'a' && ch <= (char) ('z' - key))
                encrypted += (char) (ch + key);
            else if (ch >= (char) ('Z' - key + 1) && ch <= 'Z' || ch >= (char) ('z' - key + 1) && ch <= 'z')
                encrypted += (char) (ch - (26 - key));
            else encrypted += ch;
        }
        message = encrypted;
        return message;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String decrypted = "";
        if (key == 0) return message;
        if (key >= 26) key %= 26;
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch >= (char) ('Z' - (26 - key)) && ch <= ('Z') || ch >= (char) ('z' - (26 - key)) && ch <= 'z')
                decrypted += (char) (ch - key);
            else if (ch >= 'A' && ch <= (char) ('A' + key) || ch >= 'a' && ch <= (char) ('a' + key))
                decrypted += (char) (ch + (26 - key));
            else decrypted += ch;
        }
        message = decrypted;
        return message;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println(message);
            System.out.println("Please enter your key for your cipher: ");
            int key = scan.nextInt();
            System.out.println(key);
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        } else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println(message);
            System.out.println("Please enter your key for your cipher: ");
            int key = scan.nextInt();
            System.out.println(key);
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, key));
        } else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}