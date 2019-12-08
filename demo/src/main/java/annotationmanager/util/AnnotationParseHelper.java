package annotationmanager.util;

import annotationmanager.annotation.Collection;
import annotationmanager.entity.AnnotationAssoclass;
import org.apache.commons.collections4.MapUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class AnnotationParseHelper {

    /**
     * 核心业务逻辑，利用spring容器获取注解进行解析
     **/
    public List<AnnotationAssoclass> getAnnotationAssoclasses(ApplicationContext applicationContext) {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Collection.class);
        if(MapUtils.isEmpty(beansWithAnnotation)){
            return null;
        }

        Iterator<Map.Entry<String, Object>> iterator = beansWithAnnotation.entrySet().iterator();
        List<AnnotationAssoclass> controllerAnnoDefinations = new ArrayList<>();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> ba = iterator.next();
            Object value = ba.getValue();
            Class aClass = ClassUtils.getUserClass(value.getClass());
            Collection collectionAnnotation = AnnotationUtils.findAnnotation(value.getClass
                    (), Collection.class);

            if (!collectionAnnotation.isActive()) {
                return null;
            }

            Class<? extends Annotation>[] classes = collectionAnnotation.targetAnnotations();
            HashSet<Class<? extends Annotation>> classesSet = new HashSet<>(Arrays.asList(classes));

            /**默认添加一些常用的注解**/
            classesSet.add(RequestMapping.class);
            classesSet.add(RestController.class);
            classesSet.add(Collection.class);
            //解析接口形式的注解注入

            Class<? extends Annotation> mark = null;
            Map<String, Map<String, Object>> classAnnotationMap = new HashMap<>();
            for (Class<? extends Annotation> clazz : classesSet) {
                Annotation annotation3 = aClass.getAnnotation(clazz);
                if (annotation3 == null)
                    continue;
                AnnotationAttributes annotationAttributes = AnnotationUtils.getAnnotationAttributes
                        (annotation3, true, true);
                if (annotation3.annotationType()== Collection.class) {
                    mark = Collection.class;
                    continue;
                }
                classAnnotationMap.put(clazz.getSimpleName(), annotationAttributes);
            }
            Map<String, Map<String, Object>> classMethodAnnotationMap = new HashMap();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method m : declaredMethods) {
                Annotation[] annotations = m.getAnnotations();
                Map<String, Object> annotationMap = new HashMap<>();

                for (Annotation annotation : annotations) {
                    if (!classesSet.contains(annotation.annotationType())) {
                        continue;
                    }
                    annotationMap.put(annotation.annotationType().getSimpleName
                            (), AnnotationUtils.getAnnotationAttributes(annotation));
                    classMethodAnnotationMap.put(m.getName(), annotationMap);

                }
            }

            AnnotationAssoclass annotationAssoClass = AnnotationAssoclass.buider(aClass.getSimpleName());
            annotationAssoClass.setMarkAnnotation(mark);
            annotationAssoClass.setClassMethodAnnotationMap(classMethodAnnotationMap);
            annotationAssoClass.setClassAnnotationMap(classAnnotationMap);
            controllerAnnoDefinations.add(annotationAssoClass);
        }
        return controllerAnnoDefinations;
    }

}
