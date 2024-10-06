package JavaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private List<Player> players; // 참가 선수 리스트
    private Random random; // 랜덤 숫자 생성기
    private Scanner scanner; // 입력 스캐너

    public GuessGame() {
        players = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    // 게임 시작 메서드
    public void startGame() {
        System.out.println("*** 예측 게임을 시작합니다. ***");

        // 선수 수 입력
        System.out.print("게임에 참여할 선수 수>> ");
        int playerCount = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        // 선수 이름 입력
        for (int i = 0; i < playerCount; i++) {
            System.out.print("선수 이름>> ");
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

        // 게임 반복
        while (true) {
            // 랜덤 숫자 생성
            int targetNumber = random.nextInt(100) + 1; // 1~100 사이의 숫자
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

            int closestDifference = Integer.MAX_VALUE; // 가장 가까운 차이
            Player winner = null; // 우승자

            // 각 선수의 추측 입력
            for (Player player : players) {
                System.out.print(player.getName() + ">> ");
                int guess = scanner.nextInt();
                int difference = Math.abs(targetNumber - guess); // 차이 계산

                // 가장 가까운 선수 찾기
                if (difference < closestDifference) {
                    closestDifference = difference;
                    winner = player;
                }
            }

            // 결과 출력
            System.out.println("정답은 " + targetNumber + ". " + winner.getName() + "이 이겼습니다. 승점 1점 확보!");
            winner.addScore();

            // 계속할지 여부 확인
            System.out.print("계속하려면 yes 입력>> ");
            scanner.nextLine(); // 버퍼 비우기
            String continueGame = scanner.nextLine();
            if (!continueGame.equalsIgnoreCase("yes")) {
                break; // 게임 종료
            }
        }

        // 최종 점수 출력
        System.out.println();
        for (Player player : players) {
            System.out.print(player.getName() + ": " + player.getScore() + " ");
        }
        System.out.println();

        // 최종 승자 확인
        List<String> winners = new ArrayList<>();
        int maxScore = 0;
        for (Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winners.clear(); // 새 승자가 나올 경우 이전 승자 리스트 초기화
                winners.add(player.getName());
            } else if (player.getScore() == maxScore) {
                winners.add(player.getName()); // 동점자 추가
            }
        }

        // 최종 승자 출력
        if (winners.size() > 0) {
            System.out.println(winners + "이 최종 승리하였습니다.");
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame(); // 게임 시작

        // Scanner 자원 해제
        game.scanner.close();
    }
}
