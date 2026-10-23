package com.korai.study.ch14;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
class Role {
    private int id;
    private String name;
}

@Data
@AllArgsConstructor
class User {
    private int id;
    private String username;
    private List<Role> role;
}

public class Stream02 {
    public static List<User> generatedUser() {
        List<User> users = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            User user = new User(num, "user" + num, new ArrayList<>());

            if(random.nextInt(10) % 2 == 0) {
                user.getRole().add(new Role(1, "ROLE_ADMIN"));
                user.getRole().add(new Role(2, "ROLE_USER"));
                users.add(user);
                continue;
            }

            user.getRole().add(new Role(2, "ROLE_USER"));
            users.add(user);
        }
        return users;
    }

    public static void main(String[] args) {
//        System.out.println(generatedUser());

        // List<User> adminUsers
        // List<User> users

        List<User> userAll = generatedUser();
//        System.out.println(userAll);

//        Stream<User> adminStream = userAll.stream().filter(u -> u.getRole().contains(new Role(1, "ROLE_ADMIN")));
//        List<User> adminUsers = adminStream.toList();
//        System.out.println(adminUsers);
//
//        Stream<User> userStream = userAll.stream().filter(u -> !u.getRole().contains(new Role(1, "ROLE_ADMIN")));
//        List<User> users = userStream.toList();
//        System.out.println(users);

        List<User> adminUsers = userAll.stream().filter(user -> {
            List<Role> roles = user.getRole();
            List<Role> adminRoles = roles.stream().filter(role -> role.getId() == 1).toList();
            return !adminRoles.isEmpty();
        }).toList();

        List<User> users = userAll.stream()
                .filter(user -> user.getRole()
                        .stream()
                        .filter(role -> role.getId() == 1)
                        .toList()
                        .isEmpty())
                .toList();

        System.out.println(adminUsers);
        System.out.println(users);
    }
}
