class Solution {
    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 0)[0];
    }

    public int [] findBottomLeftValue(TreeNode root, int level) {
        if(root == null) return new int [] {-1, -1};
        int [] left = findBottomLeftValue(root.left, level+1);
        int [] right =findBottomLeftValue(root.right, level+1);
        if(left[1] == -1 && right[1] == -1) return new int [] {root.val, level};
        if(right[1] == -1) return left;
        if(left[1] == -1) return right;
        if(left[1] > right[1]) return left;
        if(right[1] > left[1]) return right;
        return left;
    }
}
