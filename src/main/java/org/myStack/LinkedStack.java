package org.myStack;

public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        int deletedNode = tail.getValue();
        if (tail != null) {
            tail = tail.getPrev();
            size--;
        }
        return deletedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public String toString() {
        if (!isEmpty()) {
            Node currentNode = tail;
            StringBuilder stack = new StringBuilder(String.valueOf(currentNode.getValue()));

            while ((currentNode = currentNode.getPrev()) != null) {
                stack.append(" -> ").append(currentNode.getValue());
            }
            return stack.toString();
        }
        return "EMPTY";
    }
}
