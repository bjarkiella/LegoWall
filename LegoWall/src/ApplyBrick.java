import java.util.ArrayList;
import java.util.List;

public class ApplyBrick {
    private int layers;
    private int width;
    private BrickRules rules;
    private Bricks bricks;
    
    public ApplyBrick(int layers, int width) {
        this.layers = layers;
        this.width = width;
        this.rules = new BrickRules(width);
        this.bricks = new Bricks();
    }
    public List<List<Integer>> getLayout() {
        // Using a dynamic list of lists since the layers have different amount of bricks in each layer
        List<List<Integer>> fullLayout = new ArrayList<>();
        List<Integer> prevLayer = new ArrayList<>();
        
        // Initalizing variables for rule B
        boolean sCheck = false;
        int currentCount = 0;
        int maxCount = 50;

        // Generating each layer and applying rules
        for (int i = 0; i < layers; i++){
            List<Integer> currentLayer = rules.layerSum(); // Rule #A
            if (i == 0) {
                fullLayout.add(currentLayer);
            }    
            else {  // The currentlayer is regenerated until rule #B is fullfilled
                prevLayer = fullLayout.get(i-1);
                sCheck = rules.straightCheck(currentLayer, prevLayer);
                while (sCheck == false && currentCount <= maxCount) {
                    currentLayer = rules.layerSum();
                    sCheck = rules.straightCheck(currentLayer, prevLayer);
                    currentCount += 1;
                }
                fullLayout.add(currentLayer);
            }
        }
        // Here send the fullLayout to Rule C
        List<Integer> currentLayer = new ArrayList<>();
        int maxBrick = bricks.getMaxBrick();

        for (int j = 2; j < layers; j++) {
            if (j == layers-1) {
                System.out.println("stopher");
            }
            
            prevLayer = fullLayout.get(j-1);
            currentLayer = fullLayout.get(j);
            List<Integer> remIdx = rules.holeCheck(currentLayer, prevLayer);
            
            // Replacing the available removable idx with the brick size + the maximum brick size to be able to identify when printed out
            if (!remIdx.isEmpty()) {
                for (int k = 0; k < remIdx.size(); k++) {
                    prevLayer.set(remIdx.get(k), prevLayer.get(remIdx.get(k)) + maxBrick );
                }
            }
        }
        return fullLayout;
    }
}
