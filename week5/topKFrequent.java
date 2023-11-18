import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies, Collections.reverseOrder());
        int kthFrequency = frequencies.get(k - 1);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= kthFrequency) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
