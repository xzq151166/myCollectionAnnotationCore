package annotationmanager.bean;

import annotationmanager.config.ConfigEntity;
import org.springframework.beans.factory.FactoryBean;

public class MyConfigEntity implements FactoryBean<ConfigEntity> {
    @Override
    public ConfigEntity getObject() throws Exception {
        return new ConfigEntity();
    }

    @Override
    public Class<?> getObjectType() {
        return ConfigEntity.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
