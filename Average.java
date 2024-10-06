package JavaProject;

class Average {
    private int[] numbers;  // 최대 10개의 정수를 저장할 배열
    private int count;      // 현재 저장된 정수의 개수

    // 생성자: 배열 초기화 및 저장된 정수의 개수를 0으로 초기화
    public Average() {
        numbers = new int[10];
        count = 0;
    }

    // 정수를 배열에 저장하는 메서드
    public void put(int number) {
        if (count < 10) {
            numbers[count] = number;
            count++;
        } else {
            System.out.println("최대 10개의 숫자만 저장할 수 있습니다.");
        }
    }

    // 저장된 모든 정수를 출력하는 메서드
    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    // 저장된 정수의 평균을 계산하여 반환하는 메서드
    public double getAvg() {
        if (count == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += numbers[i];
        }
        return (double) sum / count;
    }

    // main 메서드
    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10);
        avg.put(15);
        avg.put(100);
        avg.showAll();
        System.out.println("평균은 " + avg.getAvg());
    }
}
