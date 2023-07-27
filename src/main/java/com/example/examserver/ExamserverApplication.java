package com.example.examserver;


// import com.example.examserver.services.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableScheduling
public class ExamserverApplication implements CommandLineRunner {
    // @Autowired
    // private UserService userService;
    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(ExamserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //        System.out.println("Starting code");
//        try {
//            User user = new User();
//            user.setFirstName("Rahul");
//            user.setLastName("Kumar");
//            user.setUsername("rahulkumar");
//            user.setPassword(this.bCryptPasswordEncoder.encode("123456789"));
//            user.setEmail("rahul@gmail.com");
//            user.setProfile("default.jpg");
//            user.setPhone("8700922262");
//
//            Role role = new Role();
//            role.setRoleId(45L);
//            role.setRoleName("NORMAL");
//
//            Set<UserRole> userRoleSet = new HashSet<>();
//            UserRole userRole = new UserRole();
//            userRole.setRole(role);
//            userRole.setUser(user);
//            userRoleSet.add(userRole);
//            User user1 = this.userService.createUser(user, userRoleSet);
//            System.out.println(user1.getUsername());
//        } catch (UserFoundException e) {
//            e.printStackTrace();
//        }
    }
}
