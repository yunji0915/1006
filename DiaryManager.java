package JavaProject;

import java.util.Scanner;

class Diary {
    private String[] entries;

    // 생성자
    public Diary() {
        entries = new String[30]; // 30일치 다이어리 생성
    }

    // 메모 추가
    public void addEntry(int day, String text) {
        if (day < 1 || day > 30) {
            System.out.println("잘못된 날짜입니다.");
        } else if (text.length() > 4) {
            System.out.println("메모는 4글자 이하로 입력해야 합니다.");
        } else {
            entries[day - 1] = text; // 입력한 날에 메모 저장
            System.out.println("메모가 저장되었습니다.");
        }
    }

    // 메모 보기
    public void showEntries() {
        System.out.println("***** 다이어리 내용 *****");
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                System.out.printf("%2d ... %s ...%n", i + 1, entries[i]);
            } else {
                System.out.printf("%2d ... ... ...%n", i + 1);
            }
        }
    }
}

public class DiaryManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diary diary = new Diary();
        int choice;

        System.out.println("***** 2024년 10월 다이어리 *****");

        // 메인 루프
        while (true) {
            System.out.print("기록:1, 보기:2, 종료:3>> ");
            choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (choice == 1) {
                // 메모 추가
                System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>> ");
                int date = scanner.nextInt();
                String text = scanner.nextLine();
                diary.addEntry(date, text);
            } else if (choice == 2) {
                // 메모 보기
                diary.showEntries();
            } else if (choice == 3) {
                // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }
        scanner.close(); // 스캐너 닫기
    }
}
