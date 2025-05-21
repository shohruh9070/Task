package entity;

import entity.enums.AttendanceStatus;

import java.util.Objects;

public class StudentAttendanceDaily {
    private String studentId;
    private String studentName;
    private AttendanceStatus status;
    public StudentAttendanceDaily(){}
    public StudentAttendanceDaily(String studentId, String studentName, AttendanceStatus status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentAttendanceDaily that = (StudentAttendanceDaily) o;
        return Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StudentAttendanceDaily{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", status=" + status +
                '}';
    }
}
