package com.eprogrammerz.examples.spring.springtrasaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private TaskExecutor taskExecutor;

    @Override
    public void run(String... args) throws Exception {
        Runnable t1 = this.appContext.getBean(SpringTxThread.class);
        taskExecutor.execute(t1);

        Runnable t2 = this.appContext.getBean(SpringTxThread.class);
        taskExecutor.execute(t2);

        Runnable t3 = this.appContext.getBean(SpringTxThread.class);
        taskExecutor.execute(t3);
    }
}
