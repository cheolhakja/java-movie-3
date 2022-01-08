package movie;

class Seat {
    private boolean booked;

    public Seat(boolean booked) {
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public void reserve() {
        if (!isBooked()) {
            this.booked = true;
            System.out.println("예매되었습니다");
            return;
        }

        System.out.println("이미 예매된 좌석입니다");
    }
}