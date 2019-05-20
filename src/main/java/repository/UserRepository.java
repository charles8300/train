package repository;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "trainRidePersistance")
    EntityManager entityManager;


    public List<User> getAll() {
        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void create(User user) {
        entityManager.persist(user);
    }

    public void delete(User user) {
        if (entityManager.contains(user)) {
            user = entityManager.merge(user);
        }

        entityManager.remove(user);
    }
}
