
package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionName) {
            Object bean = ac.getBean(beanName);
            System.out.println("name = " + beanName + " object = " +bean);
        }
    }

    @Test
    @DisplayName("어플리케이션 빈 출력하기")
    void findAplicationBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String beanName : beanDefinitionName) {
            BeanDefinition bean = ac.getBeanDefinition(beanName);

            if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object obean = ac.getBean(beanName);
                System.out.println("name = " + beanName + " object = " +obean);
            }
        }
    }


}
