/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wliu
 */
public class SerializeTest {
    
    private static String F_PATH = "/Users/wliu/Documents/Android/GitHub/EasyCoding/EasyCodingDemo/S1";
    
    public static void main(String[] args) {
//        Person person = new Person("A", 1);
//        F_PATH = savePersonToFile(person);
//        
//        Person readPerson = readPersonFromFile(F_PATH);
//        System.out.println("read Person == " + readPerson.toString());
        
        
        Student student = new Student("S1", 10, 5);
        student.setScore(100);

        String studentPath = savePersonToFile(student);
        Student readStudent = (Student) readPersonFromFile(studentPath);
        System.out.println("read student name == " + readStudent.getName());
        System.out.println("read student age == " + readStudent.getAge());
        System.out.println("read student grade == " + readStudent.getGrade());
        System.out.println("read student score == " + readStudent.getScore());

    }
    
    public static String savePersonToFile(Student person) {
        File personFile = new File(person.getName());
        if (personFile.exists()) {
            personFile.delete();
        }
        try {
            personFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(SerializeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(personFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            
            objectOutputStream.writeObject(person);
            System.out.println("person file path: " + personFile.getAbsolutePath());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return personFile.getAbsolutePath();
    }

    private static Student readPersonFromFile(String filePath) {
        File personFile = new File(filePath);
        Student student = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(personFile));) {
            student = (Student) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return student;
    }   
}

