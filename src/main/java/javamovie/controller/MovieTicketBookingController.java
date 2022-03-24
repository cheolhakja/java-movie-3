package javamovie.controller;

import javamovie.movie.domain.Movie;
import javamovie.movie.domain.MovieSchedule;
import javamovie.movie.domain.RowColumnPair;
import javamovie.movie.service.MovieTicketBookingService;
import javamovie.movie.service.MovieTicketBookingServiceImpl;
import javamovie.io.ConsoleInput;
import javamovie.io.Input;

public class MovieTicketBookingController {

    private int row;
    private int column;

    public void run() {
        Input input = new ConsoleInput();
        MovieTicketBookingService movieTicketBookingService = new MovieTicketBookingServiceImpl();

        RowColumnPair A1 = new RowColumnPair(1, 1);
        RowColumnPair A2 = new RowColumnPair(1, 2);
        RowColumnPair A3 = new RowColumnPair(1, 3);
        RowColumnPair A4 = new RowColumnPair(1, 4);
        RowColumnPair B1 = new RowColumnPair(2, 1);
        RowColumnPair B2 = new RowColumnPair(2, 2);
        RowColumnPair B3 = new RowColumnPair(2, 3);
        RowColumnPair C2 = new RowColumnPair(3, 2);
        movieTicketBookingService.addSchedule(new MovieSchedule(new Movie(1L),
                A1, A2, A3, A4, B1, B2, B3, C2)); //객체들을 생성하는 책임을 main이 갖고 객체를 주입받을까?

        while(true) {
            int menu = input.inputMenu();
            switch (menu) {
                case 1:
                    movieTicketBookingService.printSeats();
                    this.row = input.inputRow();
                    this.column = input.inputColumn();
                    movieTicketBookingService.reserve(row, column);
                    break;
                case 2:
                    movieTicketBookingService.printSeats();
                    this.row = input.inputRow();
                    this.column = input.inputColumn();
                    movieTicketBookingService.cancel(row, column);
                    break;
                default:
                    throw new IllegalArgumentException(); //나올 수 없는 메뉴 입력값
            }
        }
    }
}