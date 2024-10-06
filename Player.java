package JavaProject;

public class Player {
    private String name; // 선수 이름
    private int score; // 누적 점수

    // 생성자
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    // 이름 리턴
    public String getName() {
        return name;
    }

    // 점수 증가
    public void addScore() {
        score++;
    }

    // 점수 리턴
    public int getScore() {
        return score;
    }
}
