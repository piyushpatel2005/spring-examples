package com.piyushpatel2005;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // Get NumberGenerator bean from container (context)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        // call method next() to get random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);

        // get MessageGenerator bean from context
//        Game game = context.getBean(Game.class);
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMesage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());
        // call reset method using init-method in beans.xml
//        game.reset();
        // close context
        context.close();
    }
}
