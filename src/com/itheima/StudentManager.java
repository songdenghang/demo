package com.itheima;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        //创建学生对象，用于存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生信息");
            System.out.println("2.删除学生信息");
            System.out.println("3.修改学生信息");
            System.out.println("4.查看所有学生信息");
            System.out.println("5.退出");
            System.out.println("请输入你的选择：");

            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            switch (line) {
                case "1":
                    //System.out.println("添加学生信息");
                    addStudent(array);
                    break;
                case "2":
                    //System.out.println("删除学生信息");
                    deleteStudent(array);
                    break;
                case "3":
                    //System.out.println("修改学生信息");
                    updeteStudent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生信息");
                    findAllStudent(array);
                    break;
                case "5":
                    System.out.println("谢谢使用");
                    // break;
                    System.exit(0);
            }
        }
    }

    public static void addStudent(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生学号");
        String sid = sc.nextLine();
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //将学生对象添加到集合中
        array.add(s);

        //给出添加成功的提示
        System.out.println("添加成功");
    }

    public static void findAllStudent(ArrayList<Student> array) {
        //显示表头信息
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");

        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充“岁”
        if(array.size()==0) {
            System.out.println("无信息，请添加信息再查询");
            return;
        }
            for (int i = 0; i < array.size(); i++) {
                Student s = array.get(i);
                System.out.println(s.getSid() + "\t\t" + s.getName() + "\t" + s.getAge() + "岁\t" + s.getAddress());

            }

    }

    public static void deleteStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入你要删除的学生的学号");
        String sid=sc.nextLine();

        int index=-1;

        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){

                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("该信息不存在，请重新输入");
        }else{
            array.remove(index);
            System.out.println("删除成功");
        }

    }

    public static void updeteStudent(ArrayList<Student> array){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号");
        String sid = sc.nextLine();

        int index=-1;

        for(int i=0;i<array.size();i++){
            Student s = array.get(i);
            if(s.getSid().equals(sid)){

                index=i;
                break;
            }
        }
        if(index==-1){
            System.out.println("该学生不存在，请重新输入");
        }else{
            System.out.println("请输入学生新姓名");
            String name=sc.nextLine();
            System.out.println("请输入学生新年龄");
            String age=sc.nextLine();
            System.out.println("请输入学生新居住地");
            String address=sc.nextLine();

            Student s=new Student();
            s.setSid(sid);
            s.setName(name);
            s.setAge(age);
            s.setAddress(address);

            for(int i=0;i<array.size();i++) {
                Student student = array.get(i);
                if(student.getSid().equals(sid)){
                    array.set(i,s);
                    break;
                }
            }

            System.out.println("修改成功");
        }

        /*
        System.out.println("请输入学生新姓名");
        String name=sc.nextLine();
        System.out.println("请输入学生新年龄");
        String age=sc.nextLine();
        System.out.println("请输入学生新居住地");
        String address=sc.nextLine();

        Student s=new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        for(int i=0;i<array.size();i++) {
            Student student = array.get(i);
            if(student.getSid().equals(sid)){
                array.set(i,s);
                break;
            }
        }

        System.out.println("修改成功");
        */
    }
}
