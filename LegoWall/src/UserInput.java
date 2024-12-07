// TODO: Create a helper function here to get the layers and width (same process)

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    // Constructor
    public UserInput() {
        this.scanner = new Scanner(System.in);
    }
    
    public int getLayers() {
        int layers = 0;

        while (true) {
            try {
                System.out.println("Number of layers (1-100):");
                layers = scanner.nextInt();
                
                // Input checking
                if (layers <= 0 || layers > 100 ){
                    System.err.println("Number of layers should be between 1 and 100");
                }
                else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Number of layers has to be an integer, please try again");
                scanner.next();
            }
        }
        return layers;
    }

    public int getWidth() {
        int width;
        
        while (true) {
            try {
                System.out.println("Number of knobs (width) (1-50):");
                width = scanner.nextInt();
                
                // Input checking
                if (width <= 0 || width > 50 ){
                    System.err.println("Number of knobs should be between 1 and 50");
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("Number of knobs has to an integer, please try again");
                scanner.next();
            }

        }
        return width;
    }
    
    public void close() {
        scanner.close();
    }
}

