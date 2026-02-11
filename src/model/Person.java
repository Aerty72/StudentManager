package model;

public abstract class Person {
    private static int id;
    private String name;
    private int age;
    private String email;
    private boolean isStudent;

    public Person(String name, int age, String email, boolean isStudent){
        this.name = name;
        this.age = age;
        this.email = email;
        this.isStudent = isStudent;
    }

    public void getRole(){
        if (isStudent)
            System.out.println("Роль: Ученик");
        else
            System.out.println("Роль: Учитель");
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }

    public abstract void getInfo();


}
