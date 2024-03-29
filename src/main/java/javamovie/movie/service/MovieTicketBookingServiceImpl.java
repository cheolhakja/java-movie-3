package javamovie.movie.service;

import javamovie.movie.domain.*;
import javamovie.movie.exception.CannotCancelException;
import javamovie.movie.exception.CannotFindSeatException;
import javamovie.movie.exception.CannotBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class MovieTicketBookingServiceImpl implements MovieTicketBookingService {

    private MovieScheduleRepository movieScheduleRepository = new MovieScheduleRepositoryImpl();

    private IMovieRepository movieRepository = new MovieRepository();

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public MovieTicketBookingServiceImpl() {
    }

    @Override
    public boolean reserve(int row, int column) {
        try {
            MovieSchedule movieSchedule = movieScheduleRepository.findSchedule(); //한줄에 점을 두개 이상 찍지 않는다

            movieSchedule.book(row, column);
            System.out.println("예매되었습니다");

            applicationEventPublisher.publishEvent(new EventAddStatistics(this,
                    new RowColumnPair(row, column), movieSchedule));

            return true;
        } catch (CannotBookException e) {
            System.out.println("이미 예매 된 좌석입니다");
            return false;
        } catch (CannotFindSeatException e) {
            System.out.println("존재하지 않는 좌석입니다");
            return false;
        }
    }

    @Override
    public void addSchedule(MovieSchedule movieSchedule) {
        movieScheduleRepository.saveSchedule(movieSchedule);
    }

    @Override
    public void printSeats() {
        MovieSchedule movieSchedule = movieScheduleRepository.findSchedule();

        movieSchedule.printSeats();
    }

    @Override
    public void cancel(int row, int column) {
        try{
            MovieSchedule movieSchedule = movieScheduleRepository.findSchedule(); //한줄에 점을 두개 이상 찍지 않는다

            movieSchedule.cancel(row, column);
            System.out.println("예매 취소되었습니다");
        } catch(CannotCancelException e) {
            System.out.println("취소 불가능한 좌석입니다");
        } catch(CannotFindSeatException e) {
            System.out.println("존재하지 않는 좌석입니다");
        }
    }
}