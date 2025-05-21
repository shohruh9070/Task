package entity;

import java.time.LocalDate;
import java.util.List;

public class Attendance {
    private String id;
    private LocalDate date;
    private String groupId;
    private User teacher;
    private List<StudentAttendanceDaily> attendedStudents;
    public Attendance(){}
    public Attendance(String id, LocalDate date, String groupId, User teacher, List<StudentAttendanceDaily> attendedStudents) {
        this.id = id;
        this.date = date;
        this.groupId = groupId;
        this.teacher = teacher;
        this.attendedStudents = attendedStudents;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public List<StudentAttendanceDaily> getAttendedStudents() {
        return attendedStudents;
    }

    public void setAttendedStudents(List<StudentAttendanceDaily> attendedStudents) {
        this.attendedStudents = attendedStudents;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", groupId='" + groupId + '\'' +
                ", teacher=" + teacher +
                ", attendedStudents=" + attendedStudents +
                '}';
    }
}
