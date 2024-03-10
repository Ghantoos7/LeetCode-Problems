class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

    HashSet<Integer> result1 = Arrays.stream(nums1).boxed().collect(Collectors.toCollection(HashSet::new));        
    HashSet<Integer> result2 = Arrays.stream(nums2).boxed().collect(Collectors.toCollection(HashSet::new));        

        result1.retainAll(result2);

        return result1.stream().mapToInt(Integer::intValue).toArray();
    }
}