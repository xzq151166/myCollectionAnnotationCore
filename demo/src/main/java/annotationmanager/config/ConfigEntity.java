package annotationmanager.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.annotation.Annotation;

@ConfigurationProperties(prefix = "")
public class ConfigEntity {

    private String path;//配置导出的本地路径

    private Class<? extends Annotation>[] targetAnnotations;//需要添加的全局的目标注解

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Class<? extends Annotation>[] getTargetAnnotations() {
        return targetAnnotations;
    }

    public void setTargetAnnotations(Class<? extends Annotation>[] targetAnnotations) {
        this.targetAnnotations = targetAnnotations;
    }
}
