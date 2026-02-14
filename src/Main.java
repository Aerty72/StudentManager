import model.Person;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    static ArrayList<Student> students = new ArrayList<>();// СПИСОК СТУДЕНТОВ
    public static void getStudentsInfo(){ // ВЫВОД ИНФЫ ПО СТУДЕНТАМ
        for (Student s : students) { s.getInfo(); }
    }

    static ArrayList<Teacher> teachers = new ArrayList<>(); // СПИСОК ПРЕПОДОВ
    public static void getTeachersInfo(){
        for (Teacher t : teachers){
            t.getInfo();
        }
    }

    public static void main(String[] args) {

        System.out.println("Приветствуем вас в Системе управления курсами онлайн-школы\nДля начала выберите что вы хотите сделать в списке разрешенных действий: \n");
;



        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить студента");
            System.out.println("2 - Добавить преподавателя");
            System.out.println("3 - Создать курс (назначить преподавателя)");
            System.out.println("4 - Записать студента на курс");
            System.out.println("5 - Поставить оценку студенту по курсу");
            System.out.println("6 - Показать всех студентов с их средним баллом");
            System.out.println("7 - Показать рейтинг курсов по успеваемости");
            System.out.println("8 - Найти лучшего студента");
            System.out.println("9 - Информация о всех студентах");
            System.out.println("10 - Информация о всех преподавателях");
            System.out.println("12 - Выход");

            int valueMenu = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (valueMenu){
                case 1:
                    createStudent();
                    break;

                case 2:
                    craeteTeacher();
                    break;

                case 9:
                    getStudentsInfo();
                    break;

                case 10:
                    getTeachersInfo();
                    break;


                case 12:
                    System.out.println("Выход...");
                    return; // завершает main

                default:
                    System.out.println("Неверный ввод, попробуйте снова");
            }
        }




    }


    public static void createStudent(){ //МЕТОД СОЗДАНИЯ СТУДЕНТА
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

        ArrayList<Integer> grades = new ArrayList<>(); // СПИСОК ОЦЕНОК

        for (int i = 0; i < gradesKol; i++){
            int b = scanner.nextInt();
            grades.add(b);
        }

        System.out.println("Для начала заполнения курсов студента введите количество его курсов: ");
        int courseKol = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Отлично! Теперь по очереди вводите все курсы на которые записан " + name);

        LinkedList<String> Course = new LinkedList<>(); //СПИСОК КУРСОВ СТУДЕНТА
        for (int i = 0; i < courseKol; i++){
            String b = scanner.nextLine();
            Course.add(b);
        }


        Student student = new Student(name, age, email, grades, Course, true);
        System.out.print("Промежуточное добавление оценки: ");
        int addGrade = scanner.nextInt();
        student.addGrade(addGrade);
        scanner.nextLine();
        System.out.print("Промежуточное добавление курса студента: ");
        String enrollCourse = scanner.nextLine();
        student.enrollCourse(enrollCourse);
        System.out.print("====Промежуточный результат средней оценки студента: " + student.getAverageGrade() + " ====");
        System.out.println("Промежуточное удаление курса");
        student.unenrollCourse();
        students.add(student);
        System.out.println("Студент сохранен!");
        student.getInfo();

    }

    public static void craeteTeacher(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя преподавателя: ");
        String teacherName = scanner.nextLine();
        System.out.print("Введите возраст " + teacherName + ": ");
        int teacherAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите email " + teacherName + ": ");
        String teacherEmail = scanner.nextLine();
        System.out.print("Введите опыт работы " + teacherName + ": ");
        int teacherExpAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите количество курсов которые будет вести " + teacherName + ": ");
        int courseKol = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите название курсов по очереди: ");

        LinkedList<String> Course = new LinkedList<>();

        for (int i =0; i < courseKol; i++){
            String courseName = scanner.nextLine();
            Course.add(courseName);
        }
        Teacher teacher = new Teacher(teacherName, teacherAge, teacherEmail, teacherExpAge, Course, true);
        teachers.add(teacher);
        teacher.getInfo();
    }

}