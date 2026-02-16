package model;

import UniversityService.UniversityService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Course {

    private String courseName;
    private int durationHours;
    private Teacher teacher;
    private ArrayList<Student> students;

    Scanner scanner = new Scanner(System.in);

    // ===========================
    // CONSTRUCTORS
    // ===========================

    public Course(String courseName, int durationHours) {
        this.courseName = courseName;
        this.durationHours = durationHours;
        this.teacher = null;
        this.students = new ArrayList<>();
    }

    public Course(String courseName, int durationHours, Teacher teacher) {
        this.courseName = courseName;
        this.durationHours = durationHours;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public Course() {}

    // ===========================
    // INSTANCE METHODS
    // ===========================

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void getInfo(Course course) {
        System.out.println(
                "Название курса: " + courseName +
                        " | Продолжительность: " + durationHours + " часов"
        );
        Teacher.getTeacherNameForCourse(course);
    }

    // ===========================
    // STATIC: CREATE COURSE
    // ===========================

    public static void createNewCours() {
        Scanner scanner1 = new Scanner(System.in);

        if (Teacher.getKolTeachers() > 0) {

            System.out.println("Введите имя преподавателя курса: ");
            String teacherName = scanner1.nextLine();

            Teacher serchTeacher = Teacher.searchTeacherForName(teacherName);

            if (serchTeacher != null) {

                System.out.println("Введите название курса: ");
                String courseName = scanner1.nextLine();

                System.out.println("Введите длительность курса в часах: ");
                int durationHours = scanner1.nextInt();
                scanner1.nextLine();

                Course course = new Course(courseName, durationHours, serchTeacher);
                UniversityService.courses.add(course);
                serchTeacher.addCourse(course);

                System.out.println("Курс создан!");

            } else {
                System.out.println(
                        "Такого преподавателя нет.\n" +
                                "1 — Добавить преподавателя\n" +
                                "2 — Выйти"
                );

                int value = scanner1.nextInt();
                scanner1.nextLine();

                switch (value) {
                    case 1:
                        Teacher.craeteTeacher();
                        break;
                    case 2:
                        System.out.println("Выход...");
                        break;
                }
            }

        } else {
            System.out.println(
                    "Количество преподавателей: " + Teacher.getKolTeachers() +
                            ". Чтобы добавить курс, нужно сначала добавить преподавателя!"
            );
        }
    }

    public static void createNewCoursOBG(String teacherName, String courseName) {
        Scanner scanner1 = new Scanner(System.in);

        if (Teacher.getKolTeachers() > 0) {

            Teacher serchTeacher = Teacher.searchTeacherForName(teacherName);

            if (serchTeacher != null) {

                System.out.println("Введите длительность курса в часах: ");
                int durationHours = scanner1.nextInt();
                scanner1.nextLine();

                Course course = new Course(courseName, durationHours, serchTeacher);
                UniversityService.courses.add(course);
                serchTeacher.addCourse(course);

                System.out.println("Курс создан!");

            } else {
                System.out.println(
                        "Такого преподавателя нет.\n" +
                                "1 — Добавить преподавателя\n" +
                                "2 — Выйти"
                );

                int value = scanner1.nextInt();
                scanner1.nextLine();

                switch (value) {
                    case 1:
                        Teacher.craeteTeacher();
                        break;
                    case 2:
                        System.out.println("Выход...");
                        break;
                }
            }

        } else {
            System.out.println(
                    "Количество преподавателей: " + Teacher.getKolTeachers() +
                            ". Чтобы добавить курс, нужно сначала добавить преподавателя!"
            );
        }
    }

    // ===========================
    // STATIC: SEARCH
    // ===========================

    public static Course searchCourseForCourseName(String courseName) {
        for (Course c : UniversityService.courses) {
            if (c.getCourseName().equals(courseName)) {
                return c;
            }
        }
        return null;
    }

    public static void searchCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Поиск курса: ");
        String courseSearchName = scanner.nextLine();

        Course searchCourse = Course.searchCourseForCourseName(courseSearchName);

        if (searchCourse != null) {
            searchCourse.getInfo(searchCourse);
        } else {
            System.out.println("Курс не найден");
        }
    }

    // ===========================
    // INNER CLASS (EMPTY)
    // ===========================

    public class Statistics {
        public void getAverageGradeCourse() {
            // пусто
        }
    }
}
