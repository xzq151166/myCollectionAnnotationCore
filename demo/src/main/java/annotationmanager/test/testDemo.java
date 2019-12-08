package annotationmanager.test;

import annotationmanager.config.AnnoConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class testDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(AnnoConfig.class);

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).stream().forEach(e-> System.out.println(e));
        //Object configEntity = annotationConfigApplicationContext.getBean("configEntity");
        //System.out.println("====="+configEntity);
    }

    public  void compute(){
        int a=1;
        int b=1;
        int c = a+b;
        System.out.println(c);
    }
}
