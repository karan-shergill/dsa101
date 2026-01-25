// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

// Approch 1
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : nums1) {
            list.add(val);
        }
        for (int val : nums2) {
            list.add(val);
        }

        Collections.sort(list);
        double ans;
        if (list.size()%2 == 0) {
            int index = list.size()/2;
            int val = list.get(index) + list.get(index - 1);
            ans = (double)val/2; 
        } else {
            ans = list.get(list.size()/2);
        }
        return ans;
    }
}

/*
 APPROCH_2
 - create a new array nums3 of size nums1.length + nums2.length
 - pull all element of nums1 amd nums2 to nums3 - using 2 pointer in sorted manner
 - find median (nums3 will already be sorted)
 - TC: O(n+m)
 - SC: O(n+m)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;

        int[] nums3 = new int[size1 + size2];
        int i=0;
        int j=0;
        int k=0;

        while(i<size1 && j<size2) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                i++; k++;
            } else {
                nums3[k] = nums2[j];
                j++; k++;
            }
        }

        while(i<size1) {
            nums3[k] = nums1[i];
            i++; k++;
        }

        while(j<size2) {
            nums3[k] = nums2[j];
            j++; k++;
        }

        int size3 = nums3.length;
        if (size3 % 2 == 0) {
            return (nums3[size3/2] + nums3[(size3 - 1)/2])/2.0;
        } else {
            return nums3[size3/2];
        }
    }
}

//Approch 3
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        //APPROCH_3 - Involves BSoA
        //See: https://tinyurl.com/2b62g8c8

        int arr1len = arr1.length;
        int arr2len = arr2.length;

        //If arr1len is bigger swap the arrays
        //Running BS on smaller array will be efficient
        if (arr1len > arr2len) 
            return findMedianSortedArrays(arr2, arr1);

        //total length if we merge both the sorted array
        int totalLen = arr1len + arr2len; 

        //length of left half of merged sorted array
        int leftLenOftotalLen = (arr1len + arr2len + 1) / 2; 

        // Final merged sorted array - Left half + Right half 

        //apply binary search on smaller array arr1 to find how many elements can be 
        //pick from arr1 that can be part of the left half of the merged sorted array
        int low = 0, high = arr1len;
        while (low <= high) {

            // from arr1 taking mid1 number of elements for left half of the merged sorted array
            int mid1 = (low + high) / 2; 
            // from arr1 taking mid2 number of elements for left half of the merged sorted array
            int mid2 = leftLenOftotalLen - mid1;

            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < arr1len) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < arr2len) ? arr2[mid2] : Integer.MAX_VALUE;

            // cross comparison
            if (l1 <= r2 && l2 <= r1) {
                if (totalLen % 2 == 1) {
                    // even len for merged array - single element will be median
                    return Math.max(l1, l2);
                } else {
                    // even len for merged array - avg of middle 2 element will be median
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if (l1 > r2) {
                // Need to pick lesser number of elements from arr1 that can be part of left half of the merged sorted array
                // so need to reduce mid1 count - so move left by reducing high
                high = mid1 - 1;
            } else {
                // Need to pick more number of elements from arr1 that can be part of left half of the merged sorted array
                // so need to increase mid1 count - so move right by increasing low
                low = mid1 + 1;
            }
        }
        return 0; //dummy statement
    }
}
