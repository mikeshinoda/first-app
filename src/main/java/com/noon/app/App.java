package com.noon.app;

import com.noon.app.config.SpringConfig;
import com.noon.app.resource.MyHttp;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App extends Application<AppConfig>
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        new App().run("server", args[0]);

    }

    public AnnotationConfigApplicationContext registerSpring(AppConfig config) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.getBeanFactory().registerSingleton("configuration", config);
        context.refresh();
        return context;
    };

    @Override
    public void run(AppConfig config, Environment environment) {
        AnnotationConfigApplicationContext context = registerSpring(config);
        environment.jersey().register(context.getBean(MyHttp.class));
    }
}
