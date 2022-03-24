package javamovie.io;

public class HardcodingInput implements Input {
    //always return constant
    @Override
    public int inputMenu() {
        return 1;
    }

    @Override
    public int inputRow() {
        return 1;
    }

    @Override
    public int inputColumn() {
        return 2;
    }
}