import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelperArray {
    
    public static List<Integer> cumSumIntList(List<Integer> inputArray) {
        List<Integer> outputList = new ArrayList<>();
        int cumlSum = 0;
        for (int i = 0; i < inputArray.size()-1; i++) {
            cumlSum += inputArray.get(i);
            outputList.add(cumlSum);            
        }
        return outputList;
    }

    public static boolean shareListValues(List<Integer> List1, List<Integer> List2) {
        Set<Integer> set1 = new HashSet<>(List1);
        Set<Integer> set2 = new HashSet<>(List2);
        set1.retainAll(set2);

        return set1.isEmpty();
    }

}
