package annotationmanager.listener;

import annotationmanager.entity.AnnotationAssoclass;
import annotationmanager.util.AnnotationParseHelper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class CollectionListener implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

    private AnnotationParseHelper annotationParseHelper;

    private ApplicationContext applicationContext;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null || event.getApplicationContext().getParent().getParent() == null) {
            //List<AnnotationAssoclass> annotationAssoclasses = annotationParseHelper.getAnnotationAssoclasses(applicationContext);




        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
