package JavaProject;

import java.util.Scanner;

public class DicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");
        
        while (true) {
            System.out.print("한글 단어? ");
            String word = scanner.nextLine(); // 사용자로부터 입력받음
            
            if (word.equals("그만")) { // 종료 조건
                break;
            }
            
            String translation = Dictionary.kor2Eng(word); // 번역 시도
            
            if (translation != null) {
                System.out.println(word + "은 " + translation);
            } else {
                System.out.println(word + "는 저의 사전에 없습니다.");
            }
        }
        
        scanner.close(); // 스캐너 닫기
    }
}