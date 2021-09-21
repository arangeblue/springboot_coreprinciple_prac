package com.coreprinciple.basic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

/**
 *@title : SingletonWithPrototypeTest1
 *@author : wikyubok 
 *@date : "2021-09-21 15:01:22"
*/

public class SingletonWithPrototypeTest1 {
    
    @Test
    @DisplayName("SingletonWithPrototypeTest1")
    public void prototypeFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);





    }

    
    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;
        
        public void addCount() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
        
        @PostConstruct
        public void init() {

            System.out.println("PrototypeBean.init " + this);
        }
        
        @PreDestroy
        public void destroy() {
        
            System.out.println("PrototypeBean.destroy");
        }
    }
    
}