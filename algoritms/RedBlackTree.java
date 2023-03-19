package algoritms;
public class RedBlackTree {
      private Node root;
    private class Node {
        private int value;
        private Node left;
        private Node right;
        private boolean color;
    }

    public void add(int value) {
        if(root!= null) {
            addNode(root, value);
            root = rebalance(root);
            root.color = false;
        } else {
            root = new Node();
            root.color = false;
            root.value = value;
        }
    }

    private void addNode(Node node, int value) {
        if(node.value == value) return;
        else {
            if (node.value > value) {
                if(node.left != null){
                    addNode(node.left, value);
                    node.left = rebalance(node.left);
                }else {
                    node.left = new Node();
                    node.left.color = true;
                    node.left.value = value;
                }
            } else {
                if (node.right != null) {
                    addNode(node.right, value);
                    node.right = rebalance(node.right);
                } else {
                    node.right = new Node();
                    node.right.color = true;
                    node.right.value = value;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance = true;
        while (needRebalance) {
            needRebalance = false;

            if (result.right != null && result.right.color && (result.left == null || !result.left.color)) {
                needRebalance = true;
                result = rightSwap(result);
            }

            if (result.left != null && result.left.color && result.left.left != null && result.left.left.color) {
                needRebalance = true;
                result = leftSwap(result);
            }

            if (result.left != null && result.left.color && result.right != null && result.right.color) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node temp = rightChild.left;
        rightChild.left = node;
        node.right = temp;
        rightChild.color = node.color;
        node.color = true;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node temp = leftChild.right;
        leftChild.right = node;
        node.left = temp;
        leftChild.color = node.color;
        node.color = true;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.right.color = false;
        node.left.color = false;
        node.color = true;
    }
}
