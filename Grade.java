package JavaProject;

import java.util.Scanner;

class Grade {
    private String name;  // 학생 이름
    private int javaScore;  // 자바 점수
    private int webScore;   // 웹프로그래밍 점수
    private int osScore;    // 운영체제 점수

    // 생성자: 이름과 3개의 점수를 받아 초기화
    public Grade(String name, int javaScore, int webScore, int osScore) {
        this.name = name;
        this.javaScore = javaScore;
        this.webScore = webScore;
        this.osScore = osScore;
    }

    // 학생 이름 반환
    public String getName() {
        return name;
    }

    // 3개의 과목 평균을 계산하여 반환
    public int getAverage() {
        return (javaScore + webScore + osScore) / 3;
    }

    // main 메서드
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
        String name = scanner.next();
        int java = scanner.nextInt();
        int web = scanner.nextInt();
        int os = scanner.nextInt();

        Grade st = new Grade(name, java, web, os); // 한 명의 점수 객체 생성
        System.out.println(st.getName() + "의 평균은 " + st.getAverage());

        scanner.close();
    }
}
