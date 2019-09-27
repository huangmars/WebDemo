package com.huang.Service;
import com.huang.Bean.User;
import com.huang.Bean.UserExample;
import com.huang.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<User> selectUser(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andTAccountEqualTo(username).andTPasswordEqualTo(password);
        return userMapper.selectByExample(example);
    }
}
