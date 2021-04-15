package run.facet.agent.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation instrumentation) {
        try {
            ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
            Transformer transformer = ctx.getBean(Transformer.class);
            instrumentation.addTransformer(transformer);
        } catch (Throwable e) {
            System.out.println("An exception prevented the facet agent from starting.");
            e.printStackTrace();
        }
    }
}
