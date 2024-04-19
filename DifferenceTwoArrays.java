import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferenceTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashMap<Integer,List<Integer>> inp1 = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            List<Integer> temp = new ArrayList<>();
            if(inp1.containsKey(nums1[i])){
                temp = inp1.get(nums1[i]);
            }
            temp.add(i);
            inp1.put(nums1[i], temp);
        }

        HashMap<Integer,List<Integer>> inp2 = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            List<Integer> temp = new ArrayList<>();
            if(inp2.containsKey(nums2[i])){
                temp = inp2.get(nums2[i]);
            }
            temp.add(i);
            inp2.put(nums2[i], temp);
        }

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        for(int a: nums1){
            if(!inp2.containsKey(a) && !p.contains(a)){
                p.add(a);
            }
        }

        List<Integer> q = new ArrayList<>();
        for(int a: nums2){
            if(!inp1.containsKey(a) && !q.contains(a)){
                q.add(a);
            }
        }
        out.add(p);
        out.add(q);
        return out;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        System.out.println(findDifference(nums1,nums2));
    }
}
