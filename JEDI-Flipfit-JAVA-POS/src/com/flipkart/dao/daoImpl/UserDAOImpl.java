//package com.flipkart.dao.daoImpl;
//
//import com.flipkart.dao.UserDAO;
//import com.flipkart.bean.User;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class UserDAOImpl implements UserDAO {
//    ArrayList<User> users = new ArrayList<User>();
//    @Override
//    public int register(User user) {
//        users.add(user);
//        return user.getUserId();
//    }
//
//    public User loginUser(String username, String password) {
//        User tempUser = new User();
//        for (User x : users) {
//            if (x.getUsername() == username && x.getPassword() == password) {
//                tempUser = x;
//            }
//        }
//        return tempUser;
//    }
//    @Override
//    public void delete(int id) {
//        // TODO Auto-generated method stub
//        for (User x : users) {
//            if (x.getUserId() == id) {
//                users.remove(x);
//            }
//        }
//    }
//
//    @Override
//    public int updatePassword(User user, String newPassword) {
//        // TODO Auto-generated method stub
//        for (User x : users) {
//            if (x == user) {
//                x.setPassword(newPassword);
//            }
//        }
//        return 0;
//    }
//
//
//
//    // Driver
//
//}
