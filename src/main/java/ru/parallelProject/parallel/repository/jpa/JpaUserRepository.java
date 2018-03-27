package ru.parallelProject.parallel.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.parallelProject.parallel.model.User;
import ru.parallelProject.parallel.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if(user.isNew()) {
            em.persist(user);
        } else {
            em.merge(user);
        }
        return user;
    }

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
    /* 1.    User ref = em.getReference(User.class, id);
        em.remove(ref);*/

    /* 2.   TypedQuery<User> query = em.createQuery("DELETE FROM User u WHERE u.id=:id", User.class); //JPQL
        return query.setParameter("id", id).executeUpdate() != 0;*/

    return em.createNamedQuery(User.DELETE)
            .setParameter("id",id)
            .executeUpdate() != 0;
    }

    @Override
    public User getByEmail(String email) {
        List<User> users = em.createNamedQuery(User.BY_EMAIL, User.class)
                .setParameter(1, email)
                .getResultList();
        return DataAccessUtils.singleResult(users);
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }
}
