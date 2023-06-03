public class Revert {
    Node head;
    Node next;
    public void revert() {
        if(head != null && head.next != null){
            Node temp = head; //Создание временной переменной temp и присваивание ей значения головного узла списка.
            revert(head.next, head);  //Вызов рекурсивного метода revert с первым и вторым элементами списка в качестве аргументов.
            temp.next = null; //Установка ссылки next последнего элемента списка на null.
        }
    }
    private void revert(Node currentNode, Node previousNode){
        if (currentNode.next == null){ // Проверка, является ли текущий узел последним в списке.
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode); //Если текущий узел не является последним в списке, рекурсивный вызов метода revert для следующего узла списка.
        }
    } //Затем следующий узел становится предыдущим узлом, а текущий узел становится следующим узлом для предыдущего узла.

    public class Node{           //Объявление класса Node, который представляет узел списка.
        int value;
        Node next;
    }
}
