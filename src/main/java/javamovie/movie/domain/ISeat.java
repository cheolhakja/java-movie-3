package javamovie.movie.domain;

public interface ISeat {

    public boolean reserve();

    public void printSeat(int previousRow);

    public RowColumnPair rowColumnPair();

    public Long seatId();

    public ISeat bookingResult();

    public ISeat cancelingResult();
}
