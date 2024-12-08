import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        UserInput userInput = new UserInput();

        // Initializing input variables
        System.out.println(" ");
        int layers = userInput.getLayers();
        int width = userInput.getWidth();
        userInput.close();

        // Creating a layout
        ApplyBrick applyBrick = new ApplyBrick(layers, width);
        List<List<Integer>> fullLayout = applyBrick.getLayout();

        // Setting up the print brick layout
        PrintBricks printbricks = new PrintBricks(fullLayout);
        printbricks.printLayout();


        // Printing out some info
        System.out.println(" ");
        System.out.println("Number of layers:" + layers);
        System.out.println("Total width:" + width);
        printListList(fullLayout);

    }

    public static void printListList(List<List<Integer>> ListIn) {
        for (int i = 0; i < ListIn.size(); i++) {
            List<Integer> innerList = ListIn.get(i);
            System.out.println(innerList); 
        }

    }
}
