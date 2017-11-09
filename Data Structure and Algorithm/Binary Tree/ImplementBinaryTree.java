package practice;

import java.util.Scanner;

// 1 public class in java file
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public void insert(int val)
    {
        if (val <= data) {
            if (left == null)
                left = new TreeNode(val);
            else
                left.insert(val);
        } else {
            if (right == null)
                right = new TreeNode(val);
            else
                right.insert(val);
        }
    }

    public boolean find(int val)
    {
        if (val == data )
            return true;

        if (val < data)
        {
            return (left == null) ? false : left.find(val);
        }
        else
        {
            return (right == null) ? false : right.find(val);
        }
    }

    public void printInOrder()
    {
        if (left != null)
            left.printInOrder();
        System.out.print(data + " ");
        if (right != null)
            right.printInOrder();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(sc.nextInt());
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            root.insert(val);
        }
        sc.close();
        root.printInOrder();
    }
}

