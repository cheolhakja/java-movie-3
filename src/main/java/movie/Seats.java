package movie;

public class Seats {

    private Seat[][] seats;

    public Seats() {
        this.setSeats();
    }

    public boolean isBooked(int row, int column) {
        return seats[row][column].isBooked();
    }

    public boolean reserve(int row, int column) {
        return seats[row][column].reserve();
    }

    private void setSeats() {
        seats = new Seat[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seats[i][j] = new Seat(false);
            }
        }
    }
}