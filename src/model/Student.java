package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import UniversityService.UniversityService;

public class Student extends Person {

    private ArrayList<Integer> grade;
    private LinkedList<Course> enrolledCourses;

    Scanner scanner = new Scanner(System.in);

    // ===========================
    // STATIC METHODS
    // ===========================

    public static void getStudentsInfo() { // ВЫВОД ИНФЫ ПО СТУДЕНТАМ
        for (Student s : UniversityService.students) {
            s.getInfo();
        }
    }

    public static void searchCourseSForStudents(Course course) {
        Course searchCourse = Course.searchCourseForCourseName(course.getCourseName());

        if (searchCourse != null) {
            for (Student s : UniversityService.students) {
                if (searchCourse.getCourseName().equals(s.getCourse())) {
                    System.out.println("есть такое");
                }
            }
        }

        System.out.println("ytn");
    }

    public static void createStudent() { // МЕТОД СОЗДАНИЯ СТУДЕНТА
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вы в меню добавления студента, чтоб добавить нового студента введите его имя: ");
        String name = scanner.nextLine();

        System.out.println("Введите возраст студента: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите Email студента или нажмите - для пропуска");
        String email = scanner.nextLine();

        System.out.println("Для начала заполнения оценок студента введите количество его оценок: ");
        int gradesKol = scanner.nextInt();

        System.out.println("Отлично! Теперь по очереди вводите все оценки " + name + ": ");
        ArrayList<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesKol; i++) {
            int b = scanner.nextInt();
            grades.add(b);
        }

        System.out.println("Для начала заполнения курсов студента введите количество его курсов: ");
        int courseKol = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Отлично! Теперь по очереди вводите все курсы на которые записан " + name);
        LinkedList<Course> courses = new LinkedList<>();

        for (int i = 0; i < courseKol; i++) {
            String b = scanner.nextLine();
            Course courseSearch = Course.searchCourseForCourseName(b); // ВРЕМЕННЫЙ СПИСОК

            if (courseSearch != null) {
                courses.add(courseSearch);
                System.out.println("Курс " + courseSearch.getCourseName() + " найден и добавлен");
            } else {
                System.out.println("К сожалению данного курса у нас нет!");
            }
        }

        Student student = new Student(name, age, email, grades, courses);

//        System.out.print("Промежуточное добавление оценки: ");
//        int addGrade = scanner.nextInt();
//        student.addGrade(addGrade);
//        scanner.nextLine();

//        System.out.print("====Промежуточный результат средней оценки студента: "
//                + student.getAverageGrade() + " ====");

        UniversityService.students.add(student);
        for (Course course : courses){
            student.addCourse(course);     // студент → курс
            course.addStudent(student);    // курс → студент
        }




        System.out.println("Студент сохранен!");
        student.getInfo();
    }

    public void addCourse(Course course) {
        enrolledCourses.add(course);
    }

    // ===========================
    // CONSTRUCTORS
    // ===========================

    public Student(String name, int age, String email, ArrayList<Integer> grade, LinkedList<Course> enrolledCourses) {
        super(name, age, email);
        this.grade = grade;
        this.enrolledCourses = enrolledCourses;
    }

    public Student(String name, int age, String email) {
        super(name, age, email);
    }

    public Student() {}

    // ===========================
    // INSTANCE METHODS
    // ===========================

    public void getGrade() {
        System.out.println("Оценки: " + grade);
    }

    public void printCourses() {
        System.out.println("Курсы: ");
        for (Course enrol : enrolledCourses) {
            System.out.println(enrol.getCourseName());
        }
    }

    public LinkedList<Course> getCourse() {
        return enrolledCourses;
    }

    public ArrayList<Student> getStudents() {
        return UniversityService.students;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void unenrollCourse() {
        printCourses();
        System.out.print("Напишите номер курса для его удаления: ");
        int indexDeletedCourse = scanner.nextInt() - 1;
        enrolledCourses.remove(indexDeletedCourse);
    }

    public void addGrade(int addGradeInt) {
        grade.add(addGradeInt);
    }

    public void addGrade(double addGradeDouble) {
        grade.add((int) addGradeDouble);
    }

    public float getAverageGrade() {
        float summaGrade = 0;
        float GradeKol = grade.size();

        for (int g : grade) {
            summaGrade += g;
        }

        return summaGrade / GradeKol;
    }

    @Override
    public void getRole() {
        System.out.print("Роль: Ученик");
    }

    @Override
    public void getInfo() {
        System.out.println("Имя: " + getName() +
                " Возраст: " + getAge() +
                " Email: " + getEmail());

        getGrade();
        printCourses();
    }
}
