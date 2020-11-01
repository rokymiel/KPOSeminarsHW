package ru.youarewrong.task4.list;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myLinkedList = new MyLinkedList<>(1, 2, 3, 4);
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(myLinkedList.contains(3));
        System.out.println(myLinkedList.contains(7));
        myLinkedList.remove(2);
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println(myLinkedList.get(i));
        }
    }

}
