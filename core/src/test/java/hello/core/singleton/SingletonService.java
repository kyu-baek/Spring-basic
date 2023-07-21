package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //싱글톤은 객체가 1개만 생성되고 공유되는 구조. 그래서 임의로 new 키워드를 사용해서 객체를 생성하는 것을 방지하기 위해 private!!!!
    private SingletonService() {
    }

    public void logic() {
        System.out.println("Singleton 객체 로직 호출");
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //싱글톤이기 때문에 같은 객체를 공유~
        System.out.println("singletonService1 = " + singletonService1 + "\nsingletonService2 = " + singletonService2);
        assertThat(singletonService1).isSameAs(singletonService2);
    }
}

