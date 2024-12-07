
import java.util.List;

public class PrintBricks {
    private List<List<Integer>> brickLayout;
    public PrintBricks(List<List<Integer>> BrickLayout) {
        this.brickLayout = BrickLayout;
    }
    public void printLayout() {
        String[] printSigns = new String[] {"x","-"};
        for (int i = 0; i < brickLayout.size(); i++) {
            List<Integer> currentLayer = brickLayout.get(i);

            for (int j = 0; j < currentLayer.size(); j++) {
                int currentSignIdx = j % 2;
                String currentSign = printSigns[currentSignIdx];
            
                if (currentLayer.get(j) == 0) {  // In case the brick has been removed
                    currentSign = " ";
                }

                for (int k = 0; k < currentLayer.get(j);k++) {
                    System.out.print(currentSign);
                }
            }
            System.out.println(" ");
        }
    }
}
