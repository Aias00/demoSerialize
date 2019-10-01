package com.aias.demo.serializable.clone;

public class CloneDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setAge(12);
        teacher.setName("zhanglaoshi");
        Student student = new Student();
        student.setAge(19);
        student.setName("wangxiaobao");
        student.setTeacher(teacher);

        Student student1 = (Student) student.deepClone();
        System.out.println(student);
        System.out.println(student == student1);
        student1.getTeacher().setName("wanglaoshi");

        System.out.println(student1);


    }
}
