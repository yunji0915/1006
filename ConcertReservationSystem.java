package JavaProject;

import java.util.Scanner;

class ConcertReservationSystem {
    private String[][] seats; // 좌석 배열
    private final int SEAT_COUNT = 10; // 좌석 수

    public ConcertReservationSystem() {
        // 각 섹션(S, A, B)에 대해 10개의 좌석을 초기화
        seats = new String[3][SEAT_COUNT];
    }

    // 예약 메서드
    public void reserve(int section, String name, int seatNumber) {
        if (seats[section][seatNumber] != null) {
            System.out.println("좌석이 이미 예약되어 있습니다.");
        } else {
            seats[section][seatNumber] = name;
            System.out.println("예약이 완료되었습니다.");
        }
    }

    // 조회 메서드
    public void displaySeats() {
        String[] sectionNames = {"S", "A", "B"};
        for (int i = 0; i < seats.length; i++) {
            System.out.print(sectionNames[i] + ">> ");
            for (int j = 0; j < SEAT_COUNT; j++) {
                System.out.print((seats[i][j] == null ? "---" : seats[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    // 취소 메서드
    public void cancel(String name) {
        boolean found = false;
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < SEAT_COUNT; j++) {
                if (name.equals(seats[i][j])) {
                    seats[i][j] = null; // 예약 취소
                    System.out.println("예약이 취소되었습니다.");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("해당 이름으로 예약된 좌석이 없습니다.");
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConcertReservationSystem system = new ConcertReservationSystem();
        int choice;

        while (true) {
            System.out.print("명품콘서트홀 예약 시스템입니다.\n예약:1, 조회:2, 취소:3, 끝내기:4>> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: // 예약
                    System.out.print("좌석구분 S(1), A(2), B(3)>> ");
                    int section = scanner.nextInt() - 1; // 0 인덱스 조정
                    if (section < 0 || section > 2) {
                        System.out.println("잘못된 좌석 구분입니다. 다시 시도하세요.");
                        break;
                    }
                    System.out.println((section == 0 ? "S" : section == 1 ? "A" : "B") + ">>");
                    system.displaySeats(); // 현재 좌석 상태 출력
                    System.out.print("이름>> ");
                    String name = scanner.next();
                    System.out.print("번호>> ");
                    int seatNumber = scanner.nextInt() - 1; // 0 인덱스 조정
                    if (seatNumber < 0 || seatNumber >= system.SEAT_COUNT) {
                        System.out.println("잘못된 좌석 번호입니다. 다시 시도하세요.");
                    } else {
                        system.reserve(section, name, seatNumber);
                    }
                    break;
                case 2: // 조회
                    system.displaySeats();
                    break;
                case 3: // 취소
                    System.out.print("좌석 S:1, A:2, B:3>> ");
                    int cancelSection = scanner.nextInt() - 1; // 0 인덱스 조정
                    if (cancelSection < 0 || cancelSection > 2) {
                        System.out.println("잘못된 좌석 구분입니다. 다시 시도하세요.");
                        break;
                    }
                    System.out.println((cancelSection == 0 ? "S" : cancelSection == 1 ? "A" : "B") + ">>");
                    system.displaySeats(); // 현재 좌석 상태 출력
                    System.out.print("이름>> ");
                    String cancelName = scanner.next();
                    system.cancel(cancelName);
                    break;
                case 4: // 종료
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 시도하세요.");
            }
        }
    }
}
