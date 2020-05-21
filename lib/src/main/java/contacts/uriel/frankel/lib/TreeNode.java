package uriel.frankel.lib;

class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int data) {
        this.val = data;
    }

    public void add(int a) {
        if (a < val) {
            if (left == null) {
                TreeNode newLeftNode = new TreeNode(a);
                left = newLeftNode;
            } else {
                left.add(a);
            }
        } else if (a > val) {
            if (right == null) {
                TreeNode newLeftNode = new TreeNode(a);
                right = newLeftNode;
            } else {
                right.add(a);
            }
        }
    }

}