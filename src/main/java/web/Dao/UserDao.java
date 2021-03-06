package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public interface UserDao {
    User getUser(long id);
    List<User> getAll();
    void editUser(User user);
    void saveUser(User user);
    void removeUser(User user);

}
