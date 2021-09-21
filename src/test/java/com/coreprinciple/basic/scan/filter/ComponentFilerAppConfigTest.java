package com.coreprinciple.basic.scan.filter;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;    
    
public class ComponentFilerAppConfigTest {

    
    @Test
    public void filterScan() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);

        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        assertThrows(NoSuchBeanDefinitionException.class, ()-> {
            ac.getBean("beanB", BeanB.class);
        });

    }
    
    @MyIncludeComponent
    public class BeanA {
    }

    @MyExcludeComponent
    public class BeanB {
    }


    @Configuration
    @ComponentScan(includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class), 
                    excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
    static class ComponentFilterAppConfig {

    }
    
    
}
    