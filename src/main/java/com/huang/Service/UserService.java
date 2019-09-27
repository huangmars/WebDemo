package com.huang.Service;
import com.huang.Bean.User;
import java.util.List;


public interface UserService {
    public List<User> selectUser(String username, String password);
}
