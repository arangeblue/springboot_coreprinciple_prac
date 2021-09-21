package com.coreprinciple.basic.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeProviderTest {
    
    @Test
    @DisplayName("싱글톤과 프로토타입을 함께 사용할 때 발생하는 이슈를 잡기 위한 provider 사용")
    public void providerTest() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,
                PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();

        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count2 = clientBean2.logic();

        assertThat(count2).isEqualTo(1);


    }
    

    static class ClientBean {

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

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
