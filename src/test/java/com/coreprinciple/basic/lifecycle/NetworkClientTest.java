package com.coreprinciple.basic.lifecycle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;    
    
public class NetworkClientTest {

    @Test
    @DisplayName("빈 라이프사이클 테스트")
    public void lifeCycleTest(){
    
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    
        NetworkClient networkClient = ac.getBean(NetworkClient.class);

        ac.close();
    }


    @Configuration
    static class LifeCycleConfig {
        
        @Bean
        public NetworkClient networkClient() {

            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");

            return networkClient;
        }
    }


}
    