package ru.youarewrong.task3.lessonsimulator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    static Random random;
    static Scanner in;
    public static ArrayList<Student> students;
    final static String FILE_PATH = "bse1991.txt";

    public static void main(String[] args) {
        random = new Random();
        in = new Scanner(System.in);
        try {
            students = readStudentsFromFile(FILE_PATH);
            menu();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MissingFormatArgumentException e) {
            e.printStackTrace();
        }

    }

    static void showMenu() {
        System.out.println("\t1.Показать всех");
        System.out.println("\t2.Выбрать случайного отвечающего");
        System.out.println("\t3.Выбрать по фамилии");
        System.out.println("\t4.Добавить студента");
        System.out.println("\t5.Отчислить студента");
        System.out.println("\n\t0.Выйти");
    }

    static void menu() {
        while (true) {
            showMenu();
            String input = in.nextLine();
            switch (input) {
                case "1":
                    showStudents(false);
                    break;
                case "2":
                    chooseRandomStudent();
                    break;
                case "3":
                    chooseStudent();
                    break;
                case "4":
                    addStudent();
                    break;
                case "5":
                    expelStudent();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Введите число из списка!");
            }
        }

    }

    static void addStudent() {
        System.out.println("Введите фамилию, имя, (отчество)");
        students.add(readStudent());
        Collections.sort(students);
    }


    static Student readStudent() {
        while (true) {
            try {
                var input = in.nextLine().split(" ");
                if (input.length == 3) {
                    return new Student(input[0], input[1], input[2]);
                } else if (input.length == 2) {
                    return new Student(input[0], input[1]);
                }
                System.out.println("Введите фамилию, имя, (отчество)!");
            } catch (InputMismatchException e) {
                System.out.println("Введите фамилию, имя, (отчество)!");
            }

        }
    }

    static void expelStudent() {
        System.out.println("Выбирите студента для отчисления");
        showStudents(true);
        students.remove(readButton(1, students.size(), "Введите число из списка!") - 1);
    }

    static void showStudents(boolean firstSymbol) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println((firstSymbol ? i + 1 + ". " : "") + students.get(i).toString());
        }
    }


    static void chooseRandomStudent() {
        var student = students.get(random.nextInt(students.size()));
        System.out.println("Отвечать будет студент: " + student);
        setMark(student);
    }

    static void chooseStudent() {
        System.out.println("Выбирите студента");
        showStudents(true);
        var student = students.get(readButton(1, students.size(), "Введите число из списка!") - 1);
        System.out.println("Отвечать будет студент: " + student);
        setMark(student);


    }

    static void setMark(Student student) {
        System.out.println("Введите оценку студенту: ");
        student.addMark(readButton(0, 10, "Введите оценку от 0 до 10!"));
    }

    static int readButton(int leftEdge, int rightEndge, String errorMessage) {
        while (true) {
            try {
                int input = in.nextInt();
                if (input >= leftEdge && input <= rightEndge) {
                    in.nextLine();
                    return input;
                }
                System.out.println(errorMessage);
                in.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                in.nextLine();
            }

        }
    }

    static ArrayList<Student> readStudentsFromFile(String path) throws FileNotFoundException, MissingFormatArgumentException {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(path);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            var student = data.split(" ");
            if (student.length == 3) {
                students.add(new Student(student[0], student[1], student[2]));
            } else if (student.length == 2) {
                students.add(new Student(student[0], student[1]));
            } else {
                throw new MissingFormatArgumentException("Неверный формат имени студента");
            }

        }
        reader.close();
        return students;
    }
}
