public class Gb_sem_4 {

    public class RedBlackTree {
        private static final boolean RED = false;
        private static final boolean BLACK = true;

        private class Node {
            int value;
            boolean color;
            Node left;
            Node right;

            Node(int value, boolean color) {
                this.value = value;
                this.color = color;
            }
        }

        private Node root;

        public boolean find(int value) {
            Node current = root;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                if (value < current.value) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return false;
        } 
        public void push(int value) {
            root = insert(root, value);
            root.color = BLACK;
        }

        private Node insert(Node node, int value) {
            if (node == null) {
                return new Node(value, RED);
            }

            if (value < node.value) {
                node.left = insert(node.left, value);
            } else if (value > node.value) {
                node.right = insert(node.right, value);
            } else {
                node.value = value;
            }

            if (isRed(node.right) && !isRed(node.left)) {
                node = rotateLeft(node);
            }
            if (isRed(node.left) && isRed(node.left.left)) {
                node = rotateRight(node);
            }
            if (isRed(node.left) && isRed(node.right)) {
                flipColors(node);
            }

            return node;
        }

        private boolean isRed(Node node) {
            if (node == null) {
                return false;
            }
            return node.color == RED;
        }
        private Node rotateLeft(Node node) {
            Node x = node.right;
            node.right = x.left;
            x.left = node;
            x.color = node.color;
            node.color = RED;
            return x;
        }

        private Node rotateRight(Node node) {
            Node x = node.left;
            node.left = x.right;
            x.right = node;
            x.color = node.color;
            node.color = RED;
            return x;
        }

        private void flipColors(Node node) {
            node.color = RED;
            node.left.color = BLACK;
            node.right.color = BLACK;
        }
    }

    public static void main(String[] args) {

    }
}

