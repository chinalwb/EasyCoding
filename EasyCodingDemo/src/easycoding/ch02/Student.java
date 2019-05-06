/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easycoding.ch02;

import java.io.Serializable;

/**
 *
 * @author wliu
 */
public class Student extends Person implements Serializable {
//    private static String SCHOOL = "XX_SCHOOL";
    
    private int grade;
    
    public Student(String name, int age, int grade) {
//        super(name, age);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    
    private transient int score = 90;
//    private void writeObject(ObjectOutputStream objectOutputStream) throws Exception {
//        objectOutputStream.defaultWriteObject();
//        objectOutputStream.writeUTF(this.getName());
//        objectOutputStream.writeInt(score);
//    }
//    
//    private void readObject(ObjectInputStream objectInputStream) throws Exception {
//        objectInputStream.defaultReadObject();
//        String name = (String) objectInputStream.readUTF();
//        this.setName(name);
//        int scoreTmp = objectInputStream.readInt();
//        this.setScore(scoreTmp);
//    }
}
