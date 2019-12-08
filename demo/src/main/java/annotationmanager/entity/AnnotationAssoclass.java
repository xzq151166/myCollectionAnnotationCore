package annotationmanager.entity;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * 实体类，作用：
 * 1、用于描述类与注解的关系
 * 2、保存注解信息
 */
public class AnnotationAssoclass {

    private String className;

    private Map<String, Map<String, Object>> classAnnotationMap;

    private Map<String, Map<String, Object>> classMethodAnnotationMap;

    private Class<? extends Annotation> markAnnotation;

    private AnnotationAssoclass() {
    }
    public static AnnotationAssoclass buider(String className){
        AnnotationAssoclass annotationAssoclass = new AnnotationAssoclass();
        annotationAssoclass.setClassName(className);
        return annotationAssoclass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class<? extends Annotation> getMarkAnnotation() {
        return markAnnotation;
    }

    public void setMarkAnnotation(Class<? extends Annotation> markAnnotation) {
        this.markAnnotation = markAnnotation;
    }

    public Map<String, Map<String, Object>> getClassMethodAnnotationMap() {
        return classMethodAnnotationMap;
    }

    public void setClassMethodAnnotationMap(Map<String, Map<String, Object>> classMethodAnnotationMap) {
        this.classMethodAnnotationMap = classMethodAnnotationMap;
    }

    public Map<String, Map<String, Object>> getClassAnnotationMap() {
        return classAnnotationMap;
    }

    public void setClassAnnotationMap(Map<String, Map<String, Object>> classAnnotationMap) {
        this.classAnnotationMap = classAnnotationMap;
    }
}
