package db;

import entity.Attendance;
import entity.Group;
import entity.User;
import entity.enums.Role;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class DataSource {
    public static Scanner scanner  =new Scanner(System.in);
    public static Scanner strScanner  =new Scanner(System.in);

    public static Set<User> students = new HashSet<>();
    public static Set<User> users= new HashSet<>();
    public static Set<User> teachers = new HashSet<>();
    public static Set<Group> groups = new HashSet<>();
    public static Set<Attendance> attendances = new HashSet<>();
    public static User currentUser = null;
    static {
        User admin = new User("admin","admin","admin", Role.ADMIN);
        User teacher1 = new User("teacher1","teacher1","teacher1", Role.TEACHER);
        User teacher2 = new User("teacher2","teacher2","teacher2", Role.TEACHER);
        User a = new User("a","a","a", Role.STUDENT);
        User b = new User("b","b","b", Role.STUDENT);
        users.add(admin);
        users.add(teacher1);
        users.add(teacher2);
        users.add(a);
        users.add(b);
    }
}
