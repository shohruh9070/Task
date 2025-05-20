package service;

import entity.User;
import entity.enums.Role;
import static db.DataSource.*;
import java.util.Optional;

public class AuthService {
   public void service(){
       System.out.println("enter email");
       String email=strScanner.nextLine();
       System.out.println("enter password");
       String password=strScanner.nextLine();
       for (User user : users) {
           if(user.getEmail().equals(email) && user.getPassword().equals(password)){
               if(user.getRole()==Role.ADMIN){
                   new AdminService.service();
                   currentUser=user;
               }
               if(user.getRole()==Role.STUDENT){
                   new StudentService.service();
               }
               if(user.getRole()==Role.TEACHER){
                   new TeacherService.service();
               }
           }
       }
   }
}
