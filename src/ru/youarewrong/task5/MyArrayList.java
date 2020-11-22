package ru.youarewrong.task5;

import java.util.ArrayList;

public class MyArrayList<T> implements MyList<T> {

    private Object[] values;
    private int count = 0;
    private static final int DEFAULT_CAPACITY = 10;

    MyArrayList() {
        values = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Получение элемента по индексу
     *
     * @param i индекс
     * @return элемент хранящийся по переданному индексу
     * @throws IndexOutOfBoundsException если был передан индекс вне границы
     */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i < 0 || i >= size()) throw new IndexOutOfBoundsException("Передан неверный индекс");
        return (T) values[i];
    }

    /**
     * Кладет переданный элемент
     *
     * @param value элемент для сохранения в список
     */
    @Override
    public void put(T value) {
        if (size() + 1 > values.length) {
            growContainer();
        }
        count++;
        values[size() - 1] = value;
    }

    /**
     * Увеличивает размер массива, который хранит значения
     */
    private void growContainer() {
        Object[] newContainer = new Object[2 * values.length];
        System.arraycopy(values, 0, newContainer, 0, values.length);
        values = newContainer;
    }

    /**
     * Возвращает число элементов в списке
     *
     * @return число элементов в списке
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Проверяет содержится ли переданное значение в списке
     *
     * @param value значение для проверки
     * @return результат проверки
     */
    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size(); i++) {
            if (values[i] == value) return true;
        }
        return false;
    }

    /**
     * Удаление всех элементов в списке
     */
    @Override
    public void clear() {
        count = 0;
        values = new Object[DEFAULT_CAPACITY];
    }
}
