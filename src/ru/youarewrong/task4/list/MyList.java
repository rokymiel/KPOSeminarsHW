package ru.youarewrong.task4.list;

import java.util.Objects;

public interface MyList<T> {
    /**
     * Получить длинну списка
     *
     * @return длина списка
     */
    int getSize();

    /**
     * Добавляет элемент в список
     *
     * @param item элемент для добавления
     */
    void add(T item);

    /**
     * Проверяет содержится ли данный элемент в списке
     *
     * @param item элемент для проверки
     * @return содержится ли данный элемент в списке
     */
    boolean contains(T item);

    /**
     * Удаляет элемент из списка
     * Если элемента нет, то ничего не происходит
     *
     * @param item элемент, который нужно удалить
     */
    void remove(T item);

    /**
     * Получить элемент по индексу
     *
     * @param i индекс элемента
     * @return найденный элемент по индексу
     * @throws IndexOutOfBoundsException если передать индекс заходящий за пределы
     */
    T get(int i) throws IndexOutOfBoundsException;

    class Node<T> {
        /**
         * Данные хранящиеся в Node
         */
        public T data;
        /**
         * Ссылка на последующий Node
         */
        public Node<T> next;
        /**
         * Ссылка на предыдущий Node
         */
        public Node<T> previous;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        /**
         * Удаление Node
         */
        public void dispose() {
            next = null;
            previous = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || data.getClass() != o.getClass()) return false;
            T item = (T) o;
            return Objects.equals(data, item);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
