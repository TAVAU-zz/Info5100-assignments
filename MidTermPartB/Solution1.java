package MidTermPartB;

public class Solution1 {
    public static int[] reverseEvenIndices(int[] nums) {
        if (nums.length % 2 == 1) {
            nums =  revEvenImpl(nums, 0, nums.length - 1);
        }
        if (nums.length % 2 == 0) {
            nums =  revEvenImpl(nums, 0, nums.length - 2);
        }
        return nums;
    }

    public static int[] revEvenImpl(int[] array, int head, int tail) {
        if (head == tail)
            return array;

        if (head % 2 == 0 && tail % 2 == 0)
        {
            //swap(array, head, tail);
            int temp = array[head];
            array[head] = array[tail];
            array[tail] = temp;
        }
        return revEvenImpl(array, head+1, tail-1);
    }
}
