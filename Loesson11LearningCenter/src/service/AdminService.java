package service;
import entity.User;
import entity.enums.Role;

import static db.DataSource.*;
import static java.nio.file.Files.delete;
import static jdk.internal.editor.external.ExternalEditor.edit;

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
    }

    private void delete() {
    }

    private void edit() {
    }

    private void addStudent() {
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
}
