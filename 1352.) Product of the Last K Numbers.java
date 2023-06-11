class ProductOfNumbers {
    private List<Integer> prefixProduct;

    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
        prefixProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProduct = new ArrayList<>();
            prefixProduct.add(1);
        } else {
            int lastProduct = prefixProduct.get(prefixProduct.size() - 1);
            prefixProduct.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProduct.size();
        if (k >= n) {
            return 0;
        }
        int lastProduct = prefixProduct.get(n - 1);
        int prevProduct = prefixProduct.get(n - k - 1);
        return lastProduct / prevProduct;
    }
}
/* Time Complexity: O(1)
* Space Complexity: O(n)
*/

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
