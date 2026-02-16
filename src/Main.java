import model.Course;
import model.Person;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(
                "Приветствуем вас в Системе управления курсами онлайн-школы\n" +
                        "Для начала выберите, что вы хотите сделать:\n"
        );

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // ===========================
            // МЕНЮ
            // ===========================
            System.out.println("Выберите действие:");
            System.out.println("1  - Добавить студента");
            System.out.println("2  - Добавить преподавателя");
            System.out.println("3  - Создать курс (назначить преподавателя)");
            System.out.println("4  - Записать студента на курс");
            System.out.println("5  - Поставить оценку студенту по курсу");
            System.out.println("6  - Показать всех студентов с их средним баллом");
            System.out.println("7  - Показать рейтинг курсов по успеваемости");
            System.out.println("8  - Найти лучшего студента");
            System.out.println("9  - Информация о всех студентах");
            System.out.println("10 - Информация о всех преподавателях");
            System.out.println("12 - Выход");
            System.out.println("13 - Поиск преподавателя по имени");
            System.out.println("14 - Вся информация по курсам");
            System.out.println("15 - Поиск курса");

            int valueMenu = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            // ===========================
            // ОБРАБОТКА ВЫБОРА
            // ===========================
            switch (valueMenu) {

                case 1:
                    Student.createStudent();
                    break;

                case 2:
                    Teacher.craeteTeacher();
                    break;

                case 3:
                    Course.createNewCours();
                    break;

                case 9:
                    Student.getStudentsInfo();
                    break;

                case 10:
                    Teacher.getTeachersInfo();
                    break;

                case 12:
                    System.out.println("Выход...");
                    return;

                case 14:
                    // пока пусто
                    break;

                case 15:
                    Course.searchCourse();
                    break;

                default:
                    System.out.println("Неверный ввод, попробуйте снова");
            }
        }
    }
}
