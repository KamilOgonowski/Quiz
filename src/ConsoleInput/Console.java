package ConsoleInput;

import java.util.Scanner;

public class Console {
    public static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt){
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public static String getStringInput(String prompt){
        System.out.println(prompt);
        return scanner.next();
    }


}
