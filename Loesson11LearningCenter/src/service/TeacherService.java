package service;
import entity.Attendance;
import entity.Group;
import entity.StudentAttendanceDaily;
import entity.User;
import entity.enums.AttendanceStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

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
                    Attendance();
                              }
                case 4 -> {
                }
                case 5 -> {
                }
            }

        }
    }

    private void Attendance() {
        ShowGroup();
        System.out.println(" enter group id");
        String id  = strScanner.nextLine();
        for (Group group : groups) {
            if (group.getId().equals(id))
            {
                Attendance attendance = new Attendance();
                attendance.setId(UUID.randomUUID().toString());
                attendance.setTeacher(group.getTeacher());
                attendance.setDate(LocalDate.now());
                attendance.setGroupId(group.getId());
                List<StudentAttendanceDaily> list = new ArrayList<>();
                for (User student : group.getStudents()) {
                    System.out.println(student);
                    StudentAttendanceDaily studentAttendanceDaily = new StudentAttendanceDaily();
                    studentAttendanceDaily.setStatus(AttendanceStatus.ATTENDED);
                    studentAttendanceDaily.setStudentName(student.getFullName());
                    studentAttendanceDaily.setStudentId(student.getId());
                    list.add(studentAttendanceDaily);
                }
                attendance.setAttendedStudents(list);
                attendances.add(attendance);
                while(true){
                    System.out.println("""
                            0 exit
                            1 student NOT_ATTENDED
                            """);
                    switch (scanner.nextInt()){
                        case 0 ->{return;}
                        case 1 ->{
                            student();
                        }
                    }
                }


            }

        }

    private void Atten(String id) {
        for (Attendance attendance : attendances) {
            if ()
        }
    }


}

    private void student() {
        System.out.println(" enter Student id ");
        String id = strScanner.nextLine();

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

void main() {
}
