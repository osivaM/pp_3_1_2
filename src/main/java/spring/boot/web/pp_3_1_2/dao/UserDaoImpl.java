package spring.boot.web.pp_3_1_2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import spring.boot.web.pp_3_1_2.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        CriteriaQuery<User> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);

        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }
}
