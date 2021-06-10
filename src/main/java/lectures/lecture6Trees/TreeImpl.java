package lectures.lecture6Trees;


import homework2.Main;

import java.util.Stack;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    int maxDepth;
    int size;
    private Node<E> root;

    public TreeImpl(){
        this(0);
    }

    public TreeImpl(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    private class NodeAndParent {
        public int currentLevel;

        Node<E> current;
        Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this(current, parent, 0);
        }

        public NodeAndParent(Node<E> current, Node<E> parent, int currentLevel) {
            this.currentLevel = currentLevel;
            this.current = current;
            this.parent = parent;
        }
    }


    @Override
    public boolean add(E value) {
        Node<E> node = new Node<>(value);

        NodeAndParent nodeAndParent = doFind(value);
        if (nodeAndParent.current != null){  // если такой элемент уже есть
            return false;
        }

        Node<E> previous = nodeAndParent.parent;

        int level = nodeAndParent.currentLevel;
        if (level > maxDepth && maxDepth > 0){
            return false;
        }


        if (previous==null) {
            root = node;
        } else if (previous.isLeftChild(value)){
            previous.setLeftChild(node);
        } else {
            previous.setRightChild(node);
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind (E value){
        Node<E> current = root;
        Node<E> previous = null;
        int level = 1;

        while (current != null){
            if(current.getValue().equals(value)){
                return new NodeAndParent(current, previous);
            }

            previous = current;
            if (current.isLeftChild(value)) {
                current = current.getLeftChild();
            }else {
                current = current.getRightChild();
            }
            level++;
        }

        return new NodeAndParent(current, previous, level); // current is always null
    }


    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        Node<E> removedNode = nodeAndParent.current;
        Node<E> parentNode = nodeAndParent.parent;

        if (removedNode == null){
            return false;
        }

        if (removedNode.isLeaf()){
            removedLeafNode(removedNode, parentNode);
        } else if (removedNode.hasOnlyOneChild()){
            removeNodeWithOnlyOneChild(removedNode, parentNode);
        } else {
            removeNodeWithAllChildren(removedNode, parentNode);
        }
        size--;
        return true;
    }

    private void removeNodeWithAllChildren(Node<E> removedNode, Node<E> parentNode) {
        Node<E> successor = getSuccessor(removedNode);// поиск подходящего кандидата под замену удаляемому элементу
        if (removedNode == root){
            root = successor;
        }else if (parentNode.isLeftChild(removedNode.getValue())){
            parentNode.setLeftChild(successor);
        } else{
            parentNode.setRightChild(successor);
        }
        successor.setLeftChild(removedNode.getLeftChild());
    }

    private Node<E> getSuccessor(Node<E> removedNode) {
        Node<E> successor = removedNode;
        Node<E> successorParent = null;
        Node<E> current = removedNode.getRightChild();

        while (current != null){
            successorParent = successor;
            successor = current;                   // successor будет иметь значение последнего левого элемента
            current = successor.getLeftChild();
        }

        if (successor != removedNode.getRightChild() && successorParent!= null){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removedNode.getRightChild());
        }
        return successor;
    }

    private void removeNodeWithOnlyOneChild(Node<E> removedNode, Node<E> parentNode) {
        Node<E> childNode = removedNode.getLeftChild()!= null
                ? removedNode.getLeftChild()
                : removedNode.getRightChild();
        if (removedNode == root){
            root = childNode;
        } else if (parentNode.isLeftChild(removedNode.getValue())){
            parentNode.setLeftChild(childNode);
        } else {
            parentNode.setRightChild(childNode);
        }
    }

    private void removedLeafNode(Node<E> removedNode, Node<E> parentNode) {
        if (removedNode == root) {
            root = null;
        }else if (parentNode.isLeftChild(removedNode.getValue())){
            parentNode.setLeftChild(null);
        }else{
            parentNode.setRightChild(null);
        }
    }

    @Override
    public void traverse(TraverseMode mode) {
        switch (mode) {
            case IN_ORDER -> inOrder(root);
            case PRE_ORDER -> preOrder(root);
            case POST_ORDER -> postOrder(root);
            default -> throw new IllegalArgumentException("Unknown argument (TraverseMode) in method traverse(): " + mode);
        }
    }

    private void inOrder(Node<E> current) { // вначале левый дочерний элемент, затем родитель, затем правый дочерний элемент
        if (current == null){
            return;
        }
        inOrder(current.getLeftChild());
        System.out.println(current.getValue());
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) { // сначала родитель, затем левый дочерний эл-т, затем правый
        if (current == null){
            return;
        }
        System.out.println(current.getValue());
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }


    private void postOrder(Node<E> current) { // сначала дочерние элементы (левый затем правый), затем родитель
        if (current == null){
            return;
        }
        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.println(current.getValue());
    }




    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlancks = 64; // константа отвечает за количество пробелов, которые используем между элементами на текущем уровне

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty){
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlancks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()){
                Node<E> tempNode = globalStack.pop();
                if (tempNode!= null){
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild()!= null || tempNode.getRightChild()!= null){
                        isRowEmpty = false;
                    }
                }else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlancks * 2 - 2; j++){
                    System.out.print(" ");
                }
            }
            System.out.println();

            while (!localStack.isEmpty()){
                globalStack.push(localStack.pop());
            }

            nBlancks /=2;
        }
        System.out.println("................................................................");
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<E> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
    }

    private int height(Node<E> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }
}
