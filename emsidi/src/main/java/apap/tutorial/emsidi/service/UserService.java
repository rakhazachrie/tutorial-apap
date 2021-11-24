package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    UserModel getUserById(String id);
    void deleteUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getUserList();
}
