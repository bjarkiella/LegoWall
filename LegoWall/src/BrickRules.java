import java.util.ArrayList;
import java.util.List;

public class BrickRules {
    private int width;
    private Bricks bricks;
    
    public BrickRules(int width) {
        this.width = width;
        this.bricks = new Bricks();
    }

    // Rule #A - Add bricks up to width
    public List<Integer> layerSum() {
        // This method sums up one layer to the maximum width and returns the Array
        List<Integer> oneLayer = new ArrayList<>();
        int maxCount = width * 5;
        int currentCount = 0;
        int currentSum = 0;
        
        while (currentSum != width || currentCount <= maxCount) {
            int oneBrick = bricks.getOneBrick();
            
            if (oneBrick > width) {  // Quick check to make sure the brick size does not exceed the width
                continue;
            }
            
            currentSum += oneBrick;
            
            if (currentSum == width -1) { // If there is only width left, just select the one brick
                oneLayer.add(oneBrick);
                oneLayer.add(1);
                currentSum = width;
            }

            else if (currentSum > width) {  // If the summation exceeds the width, redo and select a new brick
                currentSum -= oneBrick;
            }
            else {
                oneLayer.add(oneBrick);
            }
            currentCount += 1; 
        }
        if (currentCount == maxCount) {  // In case the max iteration is reached, the remaining width is selected
            oneLayer.add(width - currentSum);
        }
        return oneLayer;
    }
    
    // Rule #B: No straight lines in two consecutvie layers
    public boolean straightCheck(List<Integer> currentLayer, List<Integer> prevLayer) {
        // Solved by getting the cumulative sum of the layers and comparing.
        List<Integer> currentCuml = HelperArray.cumSumIntList(currentLayer);
        List<Integer> prevCuml = HelperArray.cumSumIntList(prevLayer);
        boolean sCheck = HelperArray.shareListValues(currentCuml, prevCuml);
        
        return sCheck;
    }

    public List<Integer> holeCheck(List<Integer> currentLayer, List<Integer> prevLayer) {
        // Solved by indentifying the possible idx of the prevLayer where a brick can be removed
        List<Integer> holeIndex = new ArrayList<>();
        List<List<Integer>> layerRange = new ArrayList<>();

        // Condition #1 Layer has to have more than 3 values
        if (prevLayer.size() < 3) {
            return holeIndex;
        }
        int cumSum = 0;
        for (int i = 1; i < prevLayer.size()-1; i++) {  // Finding the range spans available in the prevLayer
            List<Integer> unitRange = new ArrayList<>();
            cumSum += prevLayer.get(i-1);
            unitRange.add(cumSum);
            unitRange.add(prevLayer.get(i) + cumSum);
            layerRange.add(unitRange);
        }
        
        // Looping the ranges of the prevLayer and checking the range coverage of each brick in the currentLayer
        for (int j = 1; j < layerRange.size(); j++) {  // Checking if any of the bricks in the currentLayer span the potential holes
            cumSum = 0;
            for (int k = 0; k < currentLayer.size(); k++) {  
                List<Integer> currentRange = new ArrayList<>();
                if (k == 0) {
                    currentRange.add(0);
                    currentRange.add(currentLayer.get(k));
                } else {
                    cumSum += currentLayer.get(k-1);
                    currentRange.add(cumSum);
                    currentRange.add(currentLayer.get(k) + cumSum);
                }

                // Comparing the ranges if possible
                if (currentRange.get(0) < layerRange.get(j).get(0) && currentRange.get(1) > layerRange.get(j).get(1)) {
                    holeIndex.add(j);
                    break;
                }
            }    
        }
        // If the criteria is not fully fulfilled, return just to remove the second idx brick 
        if (holeIndex.isEmpty()) {
            holeIndex.add(1);
        }
        return holeIndex;
    }
}

