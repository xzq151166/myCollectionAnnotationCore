package annotationmanager.config;

import annotationmanager.listener.CollectionListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

@Configuration
@Import(value =CollectionListener.class)
public class AnnoConfig {

    @Bean(name = "configEntity")
    @Scope("prorotype")
    @ConditionalOnMissingBean
    public ConfigEntity setConfig(){
        return new ConfigEntity();
    }

}
