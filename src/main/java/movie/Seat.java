package movie;

class Seat {
    private boolean booked;

    public Seat(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean reserve() {
        if (isBooked()) {
            throw new CannotReserveException();
        }

        this.booked = true;
        System.out.println("예매되었습니다");
        return true;
    }
}