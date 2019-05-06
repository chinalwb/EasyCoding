/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author wliu
 */
public class Student1 extends Person implements Externalizable {
    private static String SCHOOL = "XX_SCHOOL";
    
    private transient int grade;
    
    public Student1() { System.out.println("Student1 constructor!"); }
    
//    private String name;
//    private int age;
//    public Student1(String nameString, int age) {
//        this.name = nameString;
//        this.age = age;
//    }
//    
//    public Student1(String name, int age, int grade) {
////        super(name, age);
//        this.grade = grade;
//    }

    public int getGrade() {
        return grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getAge() {
//        return age;
//    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    
    private transient int score = 90;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.getName());
        out.writeInt(grade);
        out.writeUTF(SCHOOL);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        String name = in.readUTF();
        this.setName(name);
        int g = in.readInt();
        SCHOOL = in.readUTF();
        this.grade = g;
    }

    @Override
    public String toString() {
        return "S1 Object: School = " + SCHOOL + ", name " + this.getName() + ", grade == " + this.grade;
    }
    
    
    
    
    public static void main(String[] args) {
//        Student1 s1 = new Student1("MyExternalTest", 10, 110);
        Student1 s1 = new Student1();
        s1.setName("MyExternalizableTest");
        s1.setAge(10);
        s1.setScore(110);
        s1.setGrade(2);
        
        File file = new File(s1.getName());
        if (file.exists()) {
            file.delete();
        }
        
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(s1);
            
            System.out.println("Write to file: " + file.getAbsolutePath());
            
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student1 ss1 = (Student1) objectInputStream.readObject();
            
            String ss1String = ss1.toString();
            System.out.println("Student read :: " + ss1String);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
}
