package web.repository;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoIml implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "email VARCHAR(255) NOT NULL UNIQUE)";
        entityManager.createNativeQuery(sql).executeUpdate();
    }


    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void updateUser(User user) {
        if (user != null) {
            entityManager.merge(user);
        }
    }

    @Override
    public boolean deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
            return true;
        } else return false;
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }
}
