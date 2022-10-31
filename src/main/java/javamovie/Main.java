package javamovie;

import javamovie.controller.MovieTicketBookingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MovieTicketBookingController movieTicketBookingController = applicationContext.getBean(MovieTicketBookingController.class);
        movieTicketBookingController.run();
    }
}