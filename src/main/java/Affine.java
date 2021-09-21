import java.util.Scanner;

public class Affine {
    public static String encryptAffine(String message) {
        String encrypt = "";
        for(int i = 0;i<message.length();i++){
            char ch = message.charAt(i);
            if (ch>='A'&&ch<='Z')
                encrypt+=(char)(((3*(ch-65))%26)+65);
                else if (ch>='a'&&ch<='z')
                encrypt+=(char)(((3*(ch-97))%26)+97);
                else encrypt+=(char)(ch);
        }
        return encrypt;
    }

    public static String decryptAffine(String message) {
        String decrypt = "";
        for(int i = 0;i<message.length();i++){
            char ch = message.charAt(i);
            if (ch>='A'&&ch<='Z')
                decrypt+=(char)(((9*(ch-65))%26)+65);
            else if (ch>='a'&&ch<='z')
                decrypt+=(char)(((9*(ch-97))%26)+97);
            else decrypt+=(char)(ch);
        }
        return decrypt;
    }

    public static String encryptAffineKeys(String message, int key1, int key2) {
        String encrypt = "";
        for(int i = 0;i<message.length();i++){
            char ch = message.charAt(i);
            if (ch>='A'&&ch<='Z')
                encrypt+=(char)((((key1*(ch-65))+key2)%26)+65);
            else if (ch>='a'&&ch<='z')
                encrypt+=(char)((((key1*(ch-97))+key2)%26)+97);
            else encrypt+=(char)(ch);
        }
        return encrypt;
    }

    public static int modularInverse(int x) {
        int g = 0;
        while ((x*g)%26!=1){
            g++;
        }
        System.out.println(g);
        return g;
    }


    public static String decryptAffineKeys(String message, int key1, int key2) {
        String decrypt = "";
        for(int i = 0;i<message.length();i++){
            char ch = message.charAt(i);
            if (ch>='A'&&ch<='Z')
                decrypt+=(char)(((((modularInverse(key1)+26)%26)*(((ch-65)-key2)+26)%26)%26)+65);
            else if (ch>='a'&&ch<='z')
                decrypt+=(char)(((((modularInverse(key1)+26)%26)*(((ch-97)-key2)+26)%26)%26)+97);
            else decrypt+=(char)(ch);
        }
        return decrypt;
    }

    // Some basic testing code
    public static void main(String[] args) {
        System.out.println("Encrypt and Decrypt Basic Tests:");
        System.out.println(encryptAffine(("Hello, World!"))); // Vmhhq, Oqzhj!
        System.out.println(decryptAffine("Vmhhq, Oqzhj!")); // Hello, World!

        System.out.println();
        System.out.println("Modular Inverse Tests:");
        System.out.println(modularInverse(9)); // 3
        System.out.println(modularInverse(3)); // 9
        System.out.println(modularInverse(23)); // 17

        System.out.println();
        System.out.println("Affine Encrypt and Decrypt with Keys Tests:");
        System.out.println(encryptAffineKeys("hello", 5, 17)); // aluuj
        System.out.println(decryptAffineKeys("aluuj", 5, 17)); // hello
    }
}