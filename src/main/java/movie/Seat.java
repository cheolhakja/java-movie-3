package movie;

class Seat {
    private boolean isBooked;

    public Seat(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void reserve() {
        if (this.isBooked == false) {
            this.isBooked = true;
            System.out.println("예매되었습니다");
            return;
        }

        System.out.println("이미 예매된 좌석입니다");
    }
}