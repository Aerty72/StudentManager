package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Student extends Person {

    private ArrayList<Integer> grade;
    private LinkedList<String> enrolledCourses;
    private boolean isStudent;

    Scanner scanner = new Scanner(System.in);

    public Student(String name, int age, String email, ArrayList<Integer> grade, LinkedList<String> enrolledCourses, boolean isStudent){
        super(name, age, email);
        this.isStudent = isStudent;
        this.grade = grade;
        this.enrolledCourses = enrolledCourses;
    }

    public Student(String name, int age, String email, boolean isStudent){
        super(name, age, email);
        this.isStudent = isStudent;
    }

    public Student(){}

    public void getGrade() {
        System.out.println("Оценки: " + grade);
    }

    public void getCourse(){
        System.out.println("Курсы: " + enrolledCourses);
    }

    public void enrollCourse(String addCourse){
        enrolledCourses.add(addCourse);
    }

    public void unenrollCourse(){
        getCourse();
        System.out.print("Напишите номер курса для его удаления: ");
        int indexDeletedCourse = scanner.nextInt() - 1;
        enrolledCourses.remove(indexDeletedCourse);
    }

    public void addGrade(int addGradeInt){
        grade.add(addGradeInt);
    }
    public void addGrade(double addGradeDouble){
        grade.add((int) addGradeDouble);
    }
    public float getAverageGrade() { // Полу рабочий вариант
        int summaGrade = 0;
        int GradeKol = grade.size();
        for (int g : grade){
            summaGrade +=g;
        }
        float AvarageGrade = summaGrade/GradeKol;
        return AvarageGrade;
    }


    @Override
    public void getRole() {
        if (isStudent)
            System.out.print("Роль: Ученик");
        else
            System.out.println("Роль: Учитель");
    }

    @Override
    public void getInfo() {
        System.out.println("Имя: " + getName() + " Возраст: " + getAge() + " Email: " + getEmail());
        getGrade();
        getCourse();
    }





}
