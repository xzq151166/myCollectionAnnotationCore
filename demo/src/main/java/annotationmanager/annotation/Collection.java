package annotationmanager.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Collection {
    /**
     * 用于Controller类上面的注解
     * 如果标记该注解，说明此类需要收集注解信息
     */
    boolean isActive(); //注解生效开关

    String[] methodName() default {};//controller中需要收集的方法，默认为空，为空时，默认收集所有方法的注解信息

    Class<? extends Annotation>[] targetAnnotations();//目标注解，用户可自定义要收集哪一些注解的信息，程序会默认收集一些常用的注解（比如RequestMapping等等// ）
}
