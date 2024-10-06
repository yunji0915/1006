package JavaProject;

import java.util.Scanner;


class Player1 {
    private String name;

    public Player1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + ">>");
        return scanner.nextLine();
    }
}

class WordGameApp {
    private Player1[] players;
    private String currentWord;

    public WordGameApp(int playerCount) {
        players = new Player1[playerCount];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < playerCount; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            String name = scanner.nextLine();
            players[i] = new Player1(name);
        }
        currentWord = "아버지"; // 시작 단어
    }

    private boolean isValidWord(String lastWord, String newWord) {
        // 끝말의 마지막 글자와 새로운 단어의 첫 글자가 같아야 함
        return lastWord.charAt(lastWord.length() - 1) == newWord.charAt(0);
    }

    public void start() {
        System.out.println("시작하는 단어는 " + currentWord + "입니다.");

        int i = 0;
        while (true) {
            Player1 currentPlayer = players[i % players.length];
            String newWord = currentPlayer.sayWord();

            if (!isValidWord(currentWord, newWord)) {
                System.out.println(currentPlayer.getName() + "이(가) 졌습니다.");
                break;
            }

            currentWord = newWord;
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇 명입니까>>");
        int playerCount = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        WordGameApp game = new WordGameApp(playerCount);
        game.start();
        
        scanner.close();
    }
    
}
