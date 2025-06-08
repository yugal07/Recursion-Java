import java.util.ArrayList;
import java.util.List;

public class SubsetsBacktracking {
    public static List<List<Integer>> subsets(int nums[]) {
        List<List<Integer>> result= new ArrayList<>();

        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }
    public static void generateSubsets(int index , int nums[] , List<Integer> current , List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length ; i++) {
            current.add(nums[i]);

            generateSubsets(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
}
