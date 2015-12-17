package com.hsenid.app.boot;

/**
 * Created by shashika on 12/10/15.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

public class StudentAppBootStarter implements WrapperListener{

    private static final Logger logger = LoggerFactory.getLogger(StudentAppBootStarter.class);

    private AbstractApplicationContext applicationContext;

    public static void main(String[] args) {
        WrapperManager.start(new StudentAppBootStarter(), args);
    }

    @Override
    public Integer start(String[] strings) {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:dispatcher-context.xml"});
        logger.info("========================================================");
        logger.info("=============  Starting Student App ==================");
        logger.info("========================================================");
        applicationContext.start();
        logger.info("========================================================");
        logger.info("=============  Student App Started  ==================");
        logger.info("========================================================");
        return null;
    }

    @Override
    public int stop(int i) {
        logger.info("========================================================");
        logger.info("=============  Stopping Student App ==================");
        logger.info("========================================================");
        if (applicationContext != null && applicationContext.isRunning()) {
            applicationContext.stop();
        }
        logger.info("===========================================");
        logger.info("========== Stopped Student App ==========");
        logger.info("===========================================");
        return 0;
    }

    @Override
    public void controlEvent(int i) {

    }

}
