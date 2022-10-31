package javamovie;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    /*
    @ComponentScan주석이 달린 @Configuration클래스는 @Component를 스캔한다
    빈 객체를 메서드를 통해 생성할 수도 있다
    * 설정 클래스에서 메서드에 @Bean주석을 달아 직접 빈을 생성한다
    * @Component를 스캔한다
     */
}
