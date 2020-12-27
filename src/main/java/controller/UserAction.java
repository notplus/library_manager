package controller;

import dao.UserDao;
import model.User;

public class UserAction {

    public boolean isUserPwdCorrect(String username, String password) {
        UserDao userDao = new UserDao();
        boolean result = false;
        try {
            result = userDao.isUserPwdCorrect(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean isAdmin(String username) {
        UserDao userDao = new UserDao();
        boolean result = false;
        try {
            result = userDao.isAdmin(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getUserId(String username){
        UserDao userDao = new UserDao();
        int result = 0;
        try {
            result = userDao.getUserId(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
