import model.Student;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    public static void getStudentsInfo(){
        for (Student s : students) { s.getInfo(); }
    }

    public static void main(String[] args) {

        System.out.println("Приветствуем вас в Системе управления курсами онлайн-школы\nДля начала выберите что вы хотите сделать в списке разрешенных действий: \n");
;





        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить студента");
            System.out.println("2 - Показать всех студентов");
            System.out.println("3 - Выход");

            int chisloMenu = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (chisloMenu){
                case 1:
                    createStudent();
                    break;

                case 2:
                    getStudentsInfo();
                    break;

                case 3:
                    System.out.println("Выход...");
                    return; // завершает main

                default:
                    System.out.println("Неверный ввод, попробуйте снова");
            }
        }




    }


    public static void createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы в меню добавления студента, чтоб добавить нового студента введите его имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите возраст студента: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введит Email студента или нажмите - для пропуска");
        String email = scanner.nextLine();
        System.out.println("Для начала заполнения оценок студента введите количество его оценок: ");
        int gradesKol = scanner.nextInt();
        System.out.println("Отлично! Теперь по очереди вводите все оценки " + name+ ": ");

        ArrayList<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesKol; i++){
            int b = scanner.nextInt();
            grades.add(b);
        }

        System.out.println("Для начала заполнения курсов студента введите количество его курсов: ");
        int courseKol = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Отлично! Теперь по очереди вводите все курсы на которые записан " + name);

        LinkedList<String> Course = new LinkedList<>();
        for (int i = 0; i < courseKol; i++){
            String b = scanner.nextLine();
            Course.add(b);
        }

        Student student = new Student(name, age, email, true, grades, Course);
        students.add(student);
        System.out.println("Студент сохранен!");
        student.getInfo();
    }

}