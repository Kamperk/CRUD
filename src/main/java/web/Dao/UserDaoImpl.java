package web.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        entityManager.refresh(entityManager.contains(user)? user : entityManager.merge(user));
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void removeUser(User user) {
        entityManager.remove(entityManager.contains(user)? user : entityManager.merge(user));
    }
    @Override
    @Transactional
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

}
