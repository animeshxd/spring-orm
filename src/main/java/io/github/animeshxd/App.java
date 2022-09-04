package io.github.animeshxd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.animeshxd.models.User;
import io.github.animeshxd.repository.Manager;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
        Manager<User> manager = ctx.getBean(Manager.class);
        
        var user = new User("AA+");

        manager.create(user);
        System.out.println(manager.read(1));

        user.setName("AB+");
        manager.update(user);
        System.out.println(manager.read(1));

        manager.delete(user);
        System.out.println(manager.read(1));

        ctx.close();
    }
}
