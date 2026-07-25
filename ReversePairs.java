class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        
        // Recursively count reverse pairs in the left and right halves
        int count = mergeSortAndCount(nums, left, mid) + mergeSortAndCount(nums, mid + 1, right);

        // Count reverse pairs crossing the two halves
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // Merge the two sorted halves
        merge(nums, left, mid, right);
        
        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining elements from the left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining elements from the right half
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy the merged sorted elements back into the original array
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}
