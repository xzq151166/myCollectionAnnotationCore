package annotationmanager.service.impl;

import annotationmanager.entity.AnnotationAssoclass;
import annotationmanager.service.IManagerService;
import annotationmanager.util.AnnotationParseHelper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Lazy
@Component
public class ManagerServiceImpl implements IManagerService, ApplicationContextAware { //实现ApplicationContextAware 获取ApplicationContext

    private ApplicationContext applicationContext;

    @Autowired
    private AnnotationParseHelper annotationParseHelper;

    private static List<AnnotationAssoclass> annotationInfo;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @PostConstruct
    private void init(){
        annotationInfo = parseAnnotation();
    }

    /**
     * 核心业务逻辑，利用spring容器获取注解进行解析
     **/
    private List<AnnotationAssoclass> parseAnnotation() {
        List<AnnotationAssoclass> controllerAnnoDefinations =annotationParseHelper.getAnnotationAssoclasses(this.applicationContext);
        if (controllerAnnoDefinations == null)
            return null;

        return controllerAnnoDefinations;
    }

    /*返回想要的注解的数据结构结构*/
    @Override
    public List<AnnotationAssoclass> getAnnotationIfon() {
        return annotationInfo;
    }
}


