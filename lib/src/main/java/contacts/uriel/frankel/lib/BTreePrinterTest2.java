package uriel.frankel.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;



public class BTreePrinterTest2 {

    private TreeNode test1() {
        TreeNode root = new TreeNode(1);
        TreeNode n11 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3);
        TreeNode n21 = new TreeNode(4);
        TreeNode n22 = new TreeNode(5);
        TreeNode n23 = new TreeNode(6);
        TreeNode n24 = new TreeNode(7);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        // n21.left = n31;
        // n21.right = n32;
        // n22.left = n33;
        // n22.right = n34;
        // n23.left = n35;
        // n23.right = n36;
        // n24.left = n37;
        // n24.right = n35;

        return root;
    }

    private  TreeNode test2() {
        TreeNode root = new TreeNode(2);
        TreeNode n11 = new TreeNode(7);
        TreeNode n12 = new TreeNode(5);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(6);
        TreeNode n23 = new TreeNode(9);
        TreeNode n31 = new TreeNode(3);
        TreeNode n32 = new TreeNode(8);
        TreeNode n33 = new TreeNode(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;

        return root;
    }

    private static boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            } else {
                return isEqual(n1.left, n2.right) && isEqual(n1.right, n2.left);
            }
        } else if (n1 == null && n2 == null) {
            return true;
        }
        return false;

    }

    private static boolean isEqual(TreeNode n1, TreeNode n2) {
        if (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            } else {
                return isEqual(n1.left, n2.left) && isEqual(n1.right, n2.right);
            }
        } else if (n1 == null && n2 == null) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {

        // BTreePrinter.printNode(test1());
//		TreeNode n1 = test1();
//		System.out.println("n1: ");
//
//		BTreePrinter.printNode(n1);
//		System.out.println("\n");
//
//		goTrough(n1);
//		System.out.println("\n");
//
//		TreeNode n2 = test2();
//		BTreePrinter.printNode(n2);



//		goTrough(n3);
//		System.out.println("\n");
//
//		System.out.print("heighest of n1: " + heighest(n1) + " lowest of n1: " + lowest(n1) + "\n");
//		System.out.print("heighest of n2: " + heighest(n2) + " lowest of n2: " + lowest(n2) + "\n");
//		System.out.print("heighest of n3: " + heighest(n3) + " lowest of n3: " + lowest(n3) + "\n");


        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);
        TreeNode n3 = null;
        for (Integer integer : arrayList) {
            if(n3 == null){
                n3 = new TreeNode(integer);
            }else{
                n3.add(integer);
            }
        }
        BTreePrinter.printNode(n3);
        System.out.println("\n BFS");
        bfs(n3);
        String s = "abcd";
        if(s.equals(invert("dcba"))){
            System.out.println("\n ok");
        }
    }

    private static String invert(String s) {
        char[] chars = new char[s.length()];
        for (int i = s.length() - 1; i>= 0 ;i--) {
            chars[s.length() - i -1] = s.charAt(i);
        }
        return new String(chars);
    }

    private static void bfs(TreeNode n3) {
        LinkedList<LinkedList<TreeNode>> listOfLists = new LinkedList<>();

        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList<>();
        listOfLists.add(q);
        q.add(n3);
        int i = 0;
        while (i < q.size()) {
            TreeNode treeNode = q.get(i);

            i++;
            if (treeNode.left != null) {
                q2.add(treeNode.left);
            }
            if (treeNode.right != null) {
                q2.add(treeNode.right);
            }
            if (i == q.size()) {
                if (!q2.isEmpty()) {
                    listOfLists.add(q2);
                }
                q = q2;
                q2 = new LinkedList<>();
                i = 0;
            }
        }
        for (int j = 0; j < listOfLists.size(); j++) {
            LinkedList<TreeNode> l = listOfLists.get(j);
            for (int k = 0; k < l.size(); k++) {
                TreeNode t = l.get(k);
                System.out.print( t.val + ", ");

            }
            System.out.println();

        }

    }

    public static boolean isBalanced(TreeNode n) {
        return ((heighest(n) - lowest(n)) <= 1);
    }

    public static void goTrough(TreeNode n) {

        if (n == null) {
            return;
        } else {
            goTrough(n.left);
            System.out.print("" + n.val + ", ");
            goTrough(n.right);
        }

    }

    public static int height(TreeNode n) {

        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(height(n.left), height(n.right));
        }

    }

    public static int heighest(TreeNode n) {

        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(heighest(n.left), heighest(n.right));
        }

    }

    public static int lowest(TreeNode n) {

        if (n == null) {
            return 0;
        } else {
            return 1 + Math.min(lowest(n.left), lowest(n.right));
        }

    }




}