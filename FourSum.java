import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List> map = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    int val = target - nums[i] + nums[j] + nums[k];
                    int low = k+1;
                    int high = nums.length - 1;
                    while(low<=high) {
                        int mid = (low + high) / 2;
                        if(nums[mid] == val) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(val);
                            map.add(list);
                        }

                        else if(nums[mid] < val) low = mid + 1;
                        else high = mid - 1;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        Iterator<List> it = map.iterator();
        while(it.hasNext()) ans.add(it.next());
        return ans;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] nums = {1,0,-1,0};
        List<List<Integer>> ans = fs.fourSum(nums,0);
        System.out.println(ans);
    }
}
