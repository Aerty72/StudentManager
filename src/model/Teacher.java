package model;

import java.util.LinkedList;
import java.util.Scanner;

public class Teacher extends Person {
    private LinkedList<String> taughtCourses;
    private int experienceAge;
    private boolean isTeacher;

    Scanner scanner = new Scanner(System.in);

    public Teacher(String name, int age, String email, int experienceAge, LinkedList<String> taughtCourses, boolean isTeacher){
        super(name, age, email);
        this.isTeacher = isTeacher;
        this.experienceAge = experienceAge;
        this.taughtCourses = taughtCourses;
    }




    public void addCourse(){
        System.out.print("Введите название круса который хотите добавить данному преподавателю: ");
        String addCourse = scanner.nextLine();
        taughtCourses.add(addCourse);
    }

    public void removeCourse(){
        getCourse();
        System.out.print("Введите номер курса который хотите удалить у данного преподавателя: ");
        int indexDeletedCourse = scanner.nextInt() - 1;
        System.out.println(taughtCourses.get(indexDeletedCourse)+ " будет удален");
        taughtCourses.remove(indexDeletedCourse);

    }

    public int getExperienceAge(){
        return experienceAge;
    }




    @Override
    public void getInfo() {
        getRole();
        System.out.println("Имя: " + getName() + " Возраст: " + getAge() + " Email: " + getEmail() + " Комерческий опыт: " + getExperienceAge());
        getCourse();

    }

    @Override
    public void getCourse() {
        System.out.println("Курсы: " + taughtCourses);
    }

    @Override
    public void getRole() {
        if (isTeacher)
            System.out.println("Роль: Учитель");
        else
            System.out.println("Роль: Ученик");
    }
}
