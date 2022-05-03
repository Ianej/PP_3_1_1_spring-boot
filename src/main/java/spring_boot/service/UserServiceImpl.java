package spring_boot.service;

import spring_boot.dao.UserDao;
import spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return (List<User>) userDao.findAll();
    }
    @Transactional
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }
    @Transactional
    @Override
    public void updateUser(long id, User user) {
        user.setId(id);
        userDao.save(user);
    }
    @Transactional
    @Override
    public void removeUser(long id) {
        userDao.delete(getUser(id));
    }

    @Override
    public User getUser(long id) {
        return (User) userDao.findById(id).get();
    }
}
