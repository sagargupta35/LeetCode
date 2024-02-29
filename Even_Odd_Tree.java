class Solution {

    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2 != 1) return false;
        return isEvenOddTree(root, 0, new int [100001]);
    }

    public boolean isEvenOddTree(TreeNode root, int level, int [] arr) {
        if(root == null) return true;
        boolean flag = true;
        if(level%2 + root.val %2 != 1) return false;
        if(arr[level] == 0){
            arr[level] = root.val;
        } else{
            int j = arr[level];
            if(level%2 == 0){
                if(root.val <= j){
                    flag = false;
                } else arr[level] = root.val;
            } else{
                if(root.val >= j){
                    flag = false;
                } else arr[level] = root.val;
            }
        }
        if(!flag) return false;
        boolean left = isEvenOddTree(root.left, level+1, arr);
        if(!left) return false;
        return isEvenOddTree(root.right, level+1, arr);
    }
}
