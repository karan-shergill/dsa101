// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // we have n number of stores
        // we have quantities array as products
        // quantities[0] is 0th product with its quiantity
        // we need to distribute all the products presnet in quantities[] array among the store
        // note that its possible that few store get no products at all
        // no two stores can get same product
        // our main focus is NOT that all stores get products
        // our main focus is that all the product is distributes and that to without partiality

        Arrays.sort(quantities);

        // what's max / min each store can get?
        int start = 0;
        int end = quantities[quantities.length - 1];
        int possAns = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            // now we need to check it's possible to give mid number of products to store
            if (isPossibleToDistribute(n, quantities, mid)) {
                // its possible to distribute mid products to store
                possAns = mid;

                // we want mid to have lower value, as we want to give products as lowere in number as possible
                // more LEFT to make mid smaller
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return possAns;
    }

    private boolean isPossibleToDistribute(int n, int[] quantities, int mid) {
        // check if its possible to give mid number of products to store

        int productPerStore = 0;
        for (int quantity : quantities) {
            productPerStore += Math.ceil((double)quantity/mid);
        }

        // why we return TRUE when productPerStore<=n
        // TRUE because we were able to distribute mid number of products among stores
        return productPerStore <= n;
    }
}
