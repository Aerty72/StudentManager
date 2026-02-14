package model;

public abstract class Person {
    private static int id;
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person(){

    }

    public abstract void getRole();

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


    public abstract void getCourse();


}
