/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wliu
 */
public class SerializeTest {
    
    private static String F_PATH = "/Users/wliu/Documents/Android/GitHub/EasyCoding/EasyCodingDemo/A";
    
    public static void main(String[] args) {
//        Person person = new Person("A", 1);
//        
//        F_PATH = savePersonToFile(person);
        
        Person readPerson = readPersonFromFile(F_PATH);
        System.out.println("read Person == " + readPerson.toString());
    }
    
    public static String savePersonToFile(Person person) {
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
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializeTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return personFile.getAbsolutePath();
    }

    private static Person readPersonFromFile(String filePath) {
        File personFile = new File(filePath);
        Person person = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(personFile));) {
            person = (Person) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return person;
    }
    
    
    static class Person implements Serializable {

        private static final long serialVersionUID = 1L;
        private String name;
//        private int age;
        private String gender;

        public Person(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "name == " + name + ", gender == " + gender;
        }

    }
}

