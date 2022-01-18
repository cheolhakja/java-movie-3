package movie;

import java.util.Objects;

public class RowColumnPair {

    private int row;
    private int column;

    public RowColumnPair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) { //==으로 해도 되는건가?
            return true;
        }

        if (object instanceof RowColumnPair) {
            RowColumnPair rowColumnPair = (RowColumnPair) object;

            if (column == rowColumnPair.getColumn() && row == rowColumnPair.getRow()) {
                //코드의 악취
                //참고로 어떤 필드를 먼저 비교하느냐에 따라 equals의 성능을 좌우하기도 한다.
                //고로 다를 가능성이 더 크거나 비교하는 비용이 싼 필드를 먼저 비교하는 것이 좋다.
                return true;
            }
        }

        return false; //타입이 다르먼 당연히 거짓이겠지?
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}