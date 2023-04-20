package fr.assococktail.cktlParametres.configuration;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.implementadapters.ServiceCollecteurAdapter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import parametrage.repositories.ParametreRepository;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        context = ac;
    }

    @Bean
    ParametreRepository parametreRepository(){
        return new ServiceCollecteurAdapter();
    }
}
