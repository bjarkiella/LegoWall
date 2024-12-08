// TODO: Perhaps move layerSum to BrickRules class, since it is techncially a rule

import java.util.ArrayList;
import java.util.List;


public class ApplyBrick {
    private int layers;
    private int width;
    private BrickRules rules;
    
    public ApplyBrick(int layers, int width) {
        this.layers = layers;
        this.width = width;
        this.rules = new BrickRules(layers, width);
    }
    public List<List<Integer>> getLayout() {
        // Using a dynamic list of lists since the layers have different amount of bricks in each layer
        List<List<Integer>> fullLayout = new ArrayList<>();
        List<Integer> prevLayer = new ArrayList<>();
        
        // Initalizing variables for rule B
        boolean sCheck = false;
        int currentCount = 0;
        int maxCount = 50;

        for (int i = 0; i < layers; i++){
            List<Integer> currentLayer = rules.layerSum();
            if (i == 0) {
                fullLayout.add(currentLayer);
            }    
            else {  // The currentlayer is regenerated until rule B is fullfilled
                prevLayer = fullLayout.get(i-1);
                sCheck = rules.straightCheck(currentLayer, prevLayer);
                while (sCheck == false && currentCount <= maxCount) {
                    currentLayer = rules.layerSum();
                    sCheck = rules.straightCheck(currentLayer, prevLayer);
                    currentCount += 1;
                }
                fullLayout.add(currentLayer);
            }
        // Here send the fullLayout to Rule C

            // Creating one layer
            // List<Integer> currentLayer = rules.layerSum();
            // fullLayout.add(currentLayer);
        }
        return fullLayout;
    }


}
