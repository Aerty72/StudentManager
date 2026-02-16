package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import UniversityService.UniversityService;

public class Teacher extends Person {

    private LinkedList<Course> taughtCourses;
    private int experienceAge;
    private boolean isTeacher;

    Scanner scanner = new Scanner(System.in);

    // ===========================
    // CONSTRUCTORS
    // ===========================

    public Teacher(String name, int age, String email, int experienceAge) {
        super(name, age, email);
        this.experienceAge = experienceAge;
        this.taughtCourses = new LinkedList<>();
    }

    // ===========================
    // INSTANCE METHODS
    // ===========================

    public void addCourse(Course course) {
        taughtCourses.add(course);
    }



    public void removeCourse() {
        getCourse();
        System.out.print("Введите курс который хотите удалить у данного преподавателя: ");
        int indexDeletedCourse = scanner.nextInt() - 1;

        System.out.println(taughtCourses.get(indexDeletedCourse) + " будет удален");
        taughtCourses.remove(indexDeletedCourse);
    }

    public int getExperienceAge() {
        return experienceAge;
    }

    @Override
    public void getInfo() {
        getRole();
        System.out.println(
                "Имя: " + getName() +
                        " Возраст: " + getAge() +
                        " Email: " + getEmail() +
                        " Коммерческий опыт: " + getExperienceAge()
        );
    }

    @Override
    public void printCourses() {
        System.out.println("Курсы: " + taughtCourses);
    }

    @Override
    public void getRole() {
        System.out.println("Роль: Учитель");
    }

    public LinkedList<Course> getCourse() {
        return taughtCourses;
    }

    public void printCoursesFotTEacher() {
        System.out.println("Курсы: ");
        for (Course ta : taughtCourses) {
            System.out.println(ta.getCourseName());
        }
    }

    // ===========================
    // STATIC METHODS
    // ===========================

    public static void getTeacherNameForCourse(Course course) {
        for (Teacher t : UniversityService.teachers) {
            t.getName();
        }
    }

    public static int getKolTeachers() {
        return UniversityService.teachers.size();
    }

    public static void getTeachersInfo() {
        for (Teacher t : UniversityService.teachers) {
            t.getInfo();
            t.printCoursesFotTEacher();
        }
    }

    public static Teacher searchTeacherForName(String teacherName) {
        for (Teacher t : UniversityService.teachers) {
            if (t.getName().equals(teacherName)) {
                return t;
            }
        }
        return null;
    }

    // ===========================
    // CREATE TEACHER (INPUT)
    // ===========================

    public static void craeteTeacher() {
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

        Teacher teacher = new Teacher(teacherName, teacherAge, teacherEmail, teacherExpAge);
        UniversityService.teachers.add(teacher);

        for (int i = 0; i < courseKol; i++) {

            System.out.println("Введите название курса №" + (i + 1));
            String courseName = scanner.nextLine();

            Course courseSearch = Course.searchCourseForCourseName(courseName);

            if (courseSearch != null) {
                teacher.addCourse(courseSearch);
                courseSearch.setTeacher(teacher);

            } else {
                System.out.println(
                        "Такого курса не существует.\n" +
                                "1 - Не добавлять\n" +
                                "2 - Добавить новый курс"
                );

                int value = scanner.nextInt();
                scanner.nextLine();

                switch (value) {
                    case 1:
                        System.out.println("Курс " + courseName + " не был добавлен!");
                        break;

                    case 2:
                        Course.createNewCoursOBG(teacherName, courseName);
                        break;
                }
            }
        }
    }
}
