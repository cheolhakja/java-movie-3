package javamovie.statistics.domain;

import javamovie.movie.domain.Movie;
import javamovie.movie.domain.RowColumnPair;
import lombok.EqualsAndHashCode;

import java.util.*;

public class MovieStatisticsRepositoryLocal implements IMovieStastisticsRepository {

    private static final List<IMovieStatistics> movieStatisticsList = new ArrayList<>();

    public void add(IMovieStatistics movieStatistics) {
        movieStatisticsList.add(movieStatistics);
    }

    public void delete() {

    }

    private List<RowColumnPair> seatBookingDataPerMovie(Movie movie) {
        SeatStatisticsPerMovie seatStatisticsPerMovie = new SeatStatisticsPerMovie();

        for (IMovieStatistics movieStatistics : movieStatisticsList) {
            seatStatisticsPerMovie.addData(movie, movieStatistics);
        }

        return seatStatisticsPerMovie.getSeatData();
    }

    public Map<RowColumnPair, Integer> topSeatPerMovie(Movie movie, int numberOfData) {
        Map<RowColumnPair, Integer> top3SeatPerMovie = new HashMap<>();
        List<RowColumnPair> rowColumnPairs = this.seatBookingDataPerMovie(movie);
        SeatAndNumberOfBooking seatAndNumberOfBooking = new SeatAndNumberOfBooking();

        for (RowColumnPair rowColumnPair: rowColumnPairs) {
            seatAndNumberOfBooking.count(rowColumnPair);
        }

        return seatAndNumberOfBooking.mostBookedSeatPerMovie(numberOfData);
    }

    public HashMap<RowColumnPair, Integer> mostBookedSeat() {
        /*
        가장 많이 예매된 좌석 TOP3
         */
        HashMap<RowColumnPair, Integer> seatStatistics = new HashMap<>();

        for (IMovieStatistics movieStatistics: movieStatisticsList) {
            if(seatStatistics.containsKey(movieStatistics.getRowColumn())) {
                Integer integer = seatStatistics.get(movieStatistics.getRowColumn());
                seatStatistics.replace(movieStatistics.getRowColumn(), integer+1);
                continue;
            }

            seatStatistics.put(movieStatistics.getRowColumn(), 1);
        }

        return sortDescendingForTOP3Seat(seatStatistics);

        /*
        Map.Entry<RowColumnPair, Integer> firstEntry = rowColumnPairIntegerHashMap.entrySet().stream().findFirst().get();
        Map.Entry<RowColumnPair, Integer> secondEntry = rowColumnPairIntegerHashMap.entrySet().stream().skip(1L).findFirst().get();
        Map.Entry<RowColumnPair, Integer> thirdEntry = rowColumnPairIntegerHashMap.entrySet().stream().skip(2L).findFirst().get();

         */
    }

    private HashMap<RowColumnPair, Integer> sortDescendingForTOP3Seat(HashMap<RowColumnPair, Integer> hm) {
        List<Map.Entry<RowColumnPair, Integer>> list = new LinkedList<>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<RowColumnPair, Integer> >() {
            public int compare(Map.Entry<RowColumnPair, Integer> o1,
                               Map.Entry<RowColumnPair, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<RowColumnPair, Integer> temp = new LinkedHashMap<RowColumnPair, Integer>();

        for (Map.Entry<RowColumnPair, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    private class SeatStatisticsPerMovie {

        private Movie movie;
        private List<RowColumnPair> seatData = new ArrayList<>();

        public SeatStatisticsPerMovie() {

        }

        public SeatStatisticsPerMovie(Movie movie, List<RowColumnPair> seatData) {
            this.movie = movie;
            this.seatData = seatData;
        }

        public void addData(Movie baseMovie, IMovieStatistics movieStatistics) {
            if(movieStatistics.equalMovie(baseMovie)) {
                seatData.add(movieStatistics.getRowColumn());
            }

            //null handling
        }

        public List<RowColumnPair> getSeatData() {
            return this.seatData;
            //null handling
        }
    }

    private class SeatAndNumberOfBooking {

        private Map<RowColumnPair, Integer> seatAndNumberOfBooking = new LinkedHashMap<>();

        public void count(RowColumnPair rowColumnPair) {
            if(seatAndNumberOfBooking.containsKey(rowColumnPair)) {
                Integer numberOfBooking = seatAndNumberOfBooking.get(rowColumnPair);
                seatAndNumberOfBooking.replace(rowColumnPair, new Integer(numberOfBooking.intValue()+1));
                return;
            }

            seatAndNumberOfBooking.put(rowColumnPair, new Integer(1));
        }

        public Map<RowColumnPair, Integer> mostBookedSeatPerMovie(int numberOfData) {
            this.sortInDescendingOrder();
            int tmp=0;
            Map<RowColumnPair, Integer> map = new LinkedHashMap<>();
            for (Map.Entry<RowColumnPair,Integer> entry: this.seatAndNumberOfBooking.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
                tmp++;
                if(tmp == numberOfData) {
                    break;
                }
            }
            return map;
        }

        private void sortInDescendingOrder() {
            Set<Map.Entry<RowColumnPair, Integer>> entrySet = this.seatAndNumberOfBooking.entrySet();

            ArrayList<Map.Entry<RowColumnPair, Integer>> entryList = new ArrayList<>(entrySet);

            Collections.sort(entryList, new Comparator<Map.Entry<RowColumnPair, Integer>>() {

                @Override
                public int compare(Map.Entry<RowColumnPair, Integer> o1, Map.Entry<RowColumnPair, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            seatAndNumberOfBooking.clear();

            for (Map.Entry<RowColumnPair, Integer> map: entryList) {
                this.seatAndNumberOfBooking.put(map.getKey(), map.getValue());
            }
        }
    }
}
