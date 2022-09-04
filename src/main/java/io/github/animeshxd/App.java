package io.github.animeshxd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.close();
    }
}
