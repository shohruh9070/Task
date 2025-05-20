package service;
import entity.Group;
import entity.User;

import java.util.Iterator;

import static db.DataSource.*;
public class TeacherService {
    public  void service() {
        while (true) {
            System.out.println("""
                    0 exit
                    1 add students
                    2 remove student
                    3 attendance
                    4 show attendance
                    5 mark
                    """);
            switch (scanner.nextInt()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    addStudent();
                }
                case 2 -> {
                    removeStudent();
                }
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                }
            }

        }
    }
    private void removeStudent() {
        ShowGroup();
        System.out.println(" enter group id ");
        String groupId = strScanner.nextLine();

        for (Group group : groups) {
            if (groupId.equals(group.getId())){
                showGroupsStudent(group);
            }
        }



    }

    private void showGroupsStudent(Group group) {
        for (User student : group.getStudents()) {
            System.out.println(" student");

        }
        System.out.println(" enter Student Id");
            String id = strScanner.nextLine();

        for (Group group1 : groups) {
            Iterator<User> iterator = group1.getStudents().iterator();
            while (iterator.hasNext()){
                User user = iterator.next();
                if (user.getId().equals(id)){
                    iterator.remove();
                    return;
                }
            }

        }


    }

    public void ShowGroup(){
        for (Group group : groups) {
            if (group.getTeacher().getId().equals(currentUser.getId())){
                System.out.println(group);
            }
        }
    }

    private void addStudent() {
        ShowGroup();

        System.out.println(" enter group id ");
        String id  = strScanner.nextLine();
        Group addStudent = null;
        for (Group group : groups) {
            if (id.equals(group.getId())){
              addStudent= group;
            }
        }
        showStudent();
        System.out.println(" enter student id");
        String StudentId = strScanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(StudentId)){
                assert addStudent != null;
                addStudent.getStudents().add(user);
            }
        }
        for (Group group : groups) {
           if (group.getId().equals(addStudent.getId())){
               group = addStudent;
           }
        }

}

    private void showStudent() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
