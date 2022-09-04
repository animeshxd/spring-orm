package io.github.animeshxd.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import io.github.animeshxd.models.User;
import jakarta.transaction.Transactional;

@Repository
public class UserManager implements Manager<User> {

    @Autowired
    public HibernateTemplate template;


    @Override
    @Transactional // for enabling read write (default: readonly)
    public User create(User o) {
        template.persist(o);
        return o;
    }

    @Override
    @Transactional // for enabling read write (default: readonly)
    public User delete(User o) {
        template.delete(o);
        return o;
    }


    @Override
    public User read(int id) {
        return template.get(User.class, id);
    }

    @Override
    @Transactional // for enabling read write (default: readonly)
    public User update(User t) {
        template.update(t);
        return t;
    }
    
}
