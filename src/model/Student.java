package model;
import java.util.ArrayList;
import java.util.LinkedList;

public class Student extends Person {

    private ArrayList<Integer> grade;
    private LinkedList<String> enrolledCourses;

    public Student(String name, int age, String email, boolean isStudent, ArrayList<Integer> grade, LinkedList<String> enrolledCourses){
        super(name, age, email, isStudent);
        this.grade = grade;
        this.enrolledCourses = enrolledCourses;
    }

    public Student(String name, int age, String email, boolean isStudent){
        super(name, age, email, isStudent);
    }

    public void getGrade() {
        System.out.println("Оценки: " + grade);
    }

    public void getCourse(){
        System.out.println("Курсы: " + enrolledCourses);
    }

    @Override
    public void getInfo() {
        System.out.println("Имя: " + getName() + " Возраст: " + getAge() + " Email: " + getEmail());
        getGrade();
        getCourse();
    }





}
