package movie;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int inputMenu() {
        try {
            System.out.println("메뉴를 입력하세요");
            return Integer.parseInt(scanner.nextLine().trim()); //Validator가 필요하다. 메뉴는 1과 2만 입력받을 수 있음.
        } catch(IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다");
            return inputMenu();
        }
    }

    @Override
    public int inputRow() {
        try {
            System.out.println("행을 입력하세요");
            return Integer.parseInt(scanner.nextLine().trim()); //findAll메서드로 모든 영화 좌석을 얻은 뒤 입력값과 비교해보아야함
        } catch(IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다");
            return inputRow();
        }
    }

    @Override
    public int inputColumn() {
        try {
            System.out.println("열을 입력하세요");
            return Integer.parseInt(scanner.nextLine().trim());
        } catch(IllegalArgumentException e) {
            System.out.println("올바르지 않은 입력입니다");
            return inputColumn();
        }
    }
}