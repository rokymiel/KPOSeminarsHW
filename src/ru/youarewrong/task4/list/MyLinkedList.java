package ru.youarewrong.task4.list;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public MyLinkedList(T... items) {
        for (var item : items) {
            add(item);
        }
    }

    /**
     * Получить длинну списка
     *
     * @return длина списка
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Добавляет элемент в список
     *
     * @param item элемент для добавления
     */
    @Override
    public void add(T item) {
        if (head == null) {
            head = new Node<T>(item, null, null);
            tail = head;
            ++size;
            return;
        }
        Node<T> newNode = new Node<T>(item, tail, null);
        tail.next = newNode;
        tail = newNode;
        ++size;

    }

    /**
     * Проверяет содержится ли данный элемент в списке
     *
     * @param item элемент для проверки
     * @return содержится ли данный элемент в списке
     */
    @Override
    public boolean contains(T item) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.equals(item)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Удаляет элемент из списка
     * Если элемента нет, то ничего не происходит
     *
     * @param item элемент, который нужно удалить
     */
    @Override
    public void remove(T item) {
        //  Если только 1 элемент.
        if (size == 1) {
            if (head.equals(item)) {
                head = tail = null;
                size--;
                return;
            }
            return;
        }
        // Проверка первого элемента.
        if (head.equals(item)) {
            head = head.next;
            head.previous = null;
            size--;
            return;
        }
        // Проверка последнего элемента.
        if (tail.equals(item)) {
            tail = tail.previous;
            tail.next = null;
            size--;
            return;
        }
        // Проверка всех элементов.
        Node<T> currentNode = head.next;
        while (currentNode.next != null) {
            if (currentNode.equals(item)) {
                var save = currentNode.previous;
                currentNode.previous.next = currentNode.next;
                currentNode.next.previous = save;
                currentNode.dispose();
                size--;
                return;
            }
            currentNode = currentNode.next;
        }

    }

    /**
     * Получить элемент по индексу
     *
     * @param i индекс элемента
     * @return найденный элемент по индексу
     * @throws IndexOutOfBoundsException если передать индекс заходящий за пределы
     */
    @Override
    public T get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Индекс " + i + " вышел за границы");
        }
        Node<T> currentNode = head;
        for (int j = 1; j <= i; j++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }
}
