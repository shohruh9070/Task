package service;
import entity.Group;
import entity.User;
import entity.enums.Role;

import java.util.Optional;

import static db.DataSource.*;

public class AdminService {
    public void service(){
        while (true){
            System.out.println("""
                    0 exit
                    1 addTeacher
                    2 addStudent
                    3 edit
                    4 delete
                    5 creteGroup
                    6 editGroup;
                    """);
            switch (scanner.nextInt()){
             case 0->{
                 return;
             }
             case 1->{
                 addTeacher();
             }
             case 2->{
                 addStudent();
             }
             case 3->{
                 edit();
             }
             case 4->{
                 delete();
             }
             case 5->{
                 creteGroup();
             }
             case 6->{
                 editGroup();
             }
            }
        }
    }

    private void editGroup() {
    }

    private void creteGroup() {
        Group group=new Group();
        showTeachers();
        System.out.println("enter group name");
        group.setName(strScanner.nextLine());
        System.out.println("enter id for teacher group");
        String id=strScanner.nextLine();
        Optional<User> teacher = checkTeacherId(id);
        group.setTeacher(teacher.get());
        System.out.println("enter maxLessonMonth");
        group.setMaxLessonInMonth(scanner.nextInt());
        groups.add(group);
    }

    private void delete() {
        while (true){
            System.out.println("""
                    0 exit
                    1 delete teacher
                    2 delete student
                    """);
            switch (scanner.nextInt()){
                case 0->{
                    return;
                }
                case 1->{
                    deleteTeacher();
                }
                case 2->{
                    deleteStudent();
                }
            }
        }
    }

    private void deleteTeacher() {
        showTeachers();
        boolean found=false;
        System.out.println("enter id ");
        String id=strScanner.nextLine();
        for (User user: users){
            if(user.getId().equals(id) && user.getRole()==Role.ADMIN){
                users.remove(user);
                System.out.println("mufoqiyatli ochirildi");
                found=true;
            }
        }
        if(!found){
            System.out.println("ochirilmadi");
            return;
        }
    }

    private void deleteStudent() {
        showStudents();
        boolean found=false;
        System.out.println("enter id");
         String id=strScanner.nextLine();
        for (User user : users) {
            if(user.getId().equals(id) && user.getRole()==Role.STUDENT){
                users.remove(user);
                found=true;
            }
        }
        if(!found){
            System.out.println("nimadr hato boldi ochirish jarayonida");
            return;
        }

    }

    private void edit() {
    }

    private void addStudent() {
        System.out.println("enter name");
        String name=strScanner.nextLine();
        System.out.println("enter email");
        String email=strScanner.nextLine();
        System.out.println("enter password");
        String password=strScanner.nextLine();
        User user=new User(name,email,password,Role.STUDENT);
    }

    private void addTeacher() {
        System.out.println("enter name");
        String name=strScanner.nextLine();
        System.out.println("enter email");
        String email=strScanner.nextLine();
        System.out.println("enter password");
        String password=strScanner.nextLine();
        User user=new User(name,email,password, Role.TEACHER);
        teachers.add(user);
    }
    private void showTeachers(){
        for (User user : users) {
            if(user.getRole()==Role.TEACHER){
                System.out.println(user);
            }
        }
    }

    private void showStudents(){
        for (User user : users) {
            if(user.getRole()==Role.STUDENT){
                System.out.println(user);
            }
        }
    }
    private Optional<User> checkTeacherId(String id){
        for (User user : users) {
            if(user.getId().equals(id) && user.getRole()==Role.TEACHER){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
