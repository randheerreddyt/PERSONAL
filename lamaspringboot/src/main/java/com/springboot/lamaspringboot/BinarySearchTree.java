package com.springboot.lamaspringboot;

import java.util.*;
import java.lang.*;
import java.io.*;

public class BinarySearchTree {
    BSTNode root;
    Stack<BSTNode> stack;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.val)
            root.left = insertRec(root.left, key);
        if (key > root.val)
            root.right = insertRec(root.right, key);
        return root;
    }

    void deleteKey(int key) {
        root = deleteBst(root, key);
    }

    public BSTNode deleteBst(BSTNode root, int key) {
        if (root == null) {
            System.out.println("BST is empty");
            return root;
        }
        if (key < root.val)
            root.left = deleteBst(root.left, key);
        else if (key > root.val)
            root.right = deleteBst(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.val = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteBst(root.right, root.val);
        }
        return root;
    }

    int minValue(BSTNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public BSTNode search(BSTNode root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.val == key)
            return root;
        // val is greater than root's key
        if (key < root.val)
            return search(root.left, key);
        // val is less than root's key
        return search(root.right, key);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(BSTNode root) {
        if (root != null) {
            if (root.left != null)
                inorderRec(root.left);
            System.out.println(root.val);
            if (root.right != null)
                inorderRec(root.right);
        }
    }

    void postOrderRec(BSTNode root) {
        if (root != null) {
            if (root.left != null)
                postOrderRec(root.left);
            if (root.right != null)
                postOrderRec(root.right);
            System.out.println(root.val);
        }
    }

    void preOrderRec(BSTNode root) {
        if (root != null) {
            System.out.println(root.val);
            if (root.left != null)
                preOrderRec(root.left);
            if (root.right != null)
                preOrderRec(root.right);
        }
    }

    public boolean isSymmetric(BSTNode root) {
        List<Integer> leftList = new LinkedList();
        List<Integer> rightList = new LinkedList();
        leftList = inOrder(root.left, leftList);
        rightList = inOrder(root.right, rightList);
        Collections.reverse(rightList);
        for (int i = 0; i < leftList.size(); i++) {
            if (!leftList.get(i).equals(rightList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List inOrder(BSTNode root, List list) {
        if (root != null) {
            if (root.left != null)
                inOrder(root.left, list);
            list.add(root.val);
            if (root.right != null)
                inOrder(root.right, list);
        }
        return list;
    }

    public void bstItinerator(BSTNode root) {
        stack = new Stack<BSTNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        BSTNode node = stack.pop();
        int result = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }

    public boolean isBST(BSTNode tree) {
        if (tree == null) {
            return true;
        }
        if (tree.left != null && tree.left.val > tree.val) {
            return false;
        }
        if (tree.right != null && tree.right.val < tree.val) {
            return false;
        }
        return isBST(tree.left) && isBST(tree.right);
    }

    public BSTNode findLCA(BSTNode root) {
        return lowestCommonAncestor(root, root.left, root.right);
    }

    public BSTNode lowestCommonAncestor(BSTNode root, BSTNode p, BSTNode q) {
        BSTNode m = root;

        if (m.val > p.val && m.val < q.val) {
            return m;
        } else if (m.val > p.val && m.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (m.val < p.val && m.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public final void InvertBT(BSTNode head) {
        if (head == null) {
            return;
        }
        InvertBT(head.left);
        InvertBT(head.right);
        BSTNode temp = head.left;
        head.left = head.right;
        head.right = temp;
    }

    public int maxDepth(BSTNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int bigger = Math.max(leftDepth, rightDepth);

        return bigger + 1;
    }
    
    int sum(Node node)  
    { 
        if (node == null) 
            return 0; 
        return sum(node.left) + node.data + sum(node.right); 
    } 
   
    /* returns 1 if sum property holds for the given 
       node and both of its children */
    int isSumTree(Node node)  
    { 
        int ls, rs; 
   
        /* If node is NULL or it's a leaf node then 
           return true */
        if ((node == null) || (node.left == null && node.right == null)) 
            return 1; 
   
        /* Get sum of nodes in left and right subtrees */
        ls = sum(node.left); 
        rs = sum(node.right); 
   
        /* if the node and both of its children satisfy the 
           property return 1 else 0*/
        if ((node.data == ls + rs) && (isSumTree(node.left) != 0) 
                && (isSumTree(node.right)) != 0) 
            return 1; 
   
        return 0; 
    } 

//    public BSTNode swapTwoNodes(BSTNode firstNode, BSTNode secNode){
//            BSTNode temp = secNode;
//            secNode = firstNode;
//            firstNode = temp;
//    }

    public BSTNode correctSwappedBST(BSTNode tree) {
        if (tree == null) {
            return tree;
        }

        correctSwappedBST(tree.left);
        correctSwappedBST(tree.right);

        if (tree.left != null && tree.left.val > tree.val) {
            BSTNode temp = tree.left;
            tree.left = tree;
            tree = temp;
        }
        if (tree.right != null && tree.right.val < tree.val) {
            BSTNode temp = tree.right;
            tree.right = tree;
            tree = temp;
        }


        return tree;
    }
    
    public boolean findTarget(TreeNode root, int k) {
        List < Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode tree = new BSTNode(7);

        tree.left = new BSTNode(5);
        tree.right = new BSTNode(9);

        tree.left.left = new BSTNode(3);
        tree.left.right = new BSTNode(6);
        tree.right.left = new BSTNode(8);
        tree.right.right = new BSTNode(10);

//        tree.left.left.left =new BSTNode(5);
//        tree.left.left.right =new BSTNode(6);
//        tree.left.right.left = new BSTNode(5);
//        tree.left.right.right = new BSTNode(8);
//
//        tree.right.left.left = new BSTNode(8);
//        tree.right.left.right = new BSTNode(7);
//        tree.right.right.left = new BSTNode(6);
//        tree.right.right.right = new BSTNode(5);
        bst.postOrderRec(tree);
        bst.inorderRec(tree);
        bst.preOrderRec(tree);
//        bst.correctSwappedBST(tree);
//        bst.inorderRec(tree);

//        System.out.println(bst.isSymmetric(tree));
//        bst.inorderRec(tree);
//        bst.InvertBT(tree);
//        bst.inorderRec(tree);

//        System.out.println(bst.isBST(tree));
//        System.out.println(bst.lowestCommonAncestor(tree.right, tree.right.right.right, tree.right.left).val);
//        bst.bstItinerator(tree);
//        while (bst.hasNext()) {
//            System.out.println(bst.next());
//        }
//        bst.deleteKey(7);
//        bst.inorder();
//        System.out.println(bst.search(bst.root, 5).val);
    }
}
