package JavaProject;

class Account {
    private int balance; // 계좌 잔액

    // 생성자: 초기 잔액 설정
    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    // 예금 메서드
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 예금 배열 처리 메서드
    public void deposit(int[] amounts) {
        for (int amount : amounts) {
            deposit(amount); // 각 금액을 예금
        }
    }

    // 잔액 조회 메서드
    public int getBalance() {
        return balance;
    }

    // 인출 메서드
    public int withdraw(int amount) {
        if (amount > balance) {
            int withdrawnAmount = balance; // 잔금이 부족한 경우 잔금만 인출
            balance = 0; // 잔고를 0으로 설정
            return withdrawnAmount; // 인출된 금액 리턴
        } else {
            balance -= amount; // 요청 금액만큼 잔액 차감
            return amount; // 요청된 금액 리턴
        }
    }

    // main 메서드
    public static void main(String[] args) {
        Account a = new Account(100); // 100원을 예금하면서 계좌 생성
        a.deposit(5000); // 5000원 예금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int bulk[] = {100, 500, 200, 700};
        a.deposit(bulk); // bulk[] 배열에 있는 모든 돈 예금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int money = 1000; // 인출하고자 하는 금액
        int wMoney = a.withdraw(money); // 1000원 인출 시도, wMoney는 실제 인출한 금액
        if (wMoney < money) 
            System.out.println(wMoney + "원만 인출"); // 잔금이 1000원보다 적은 경우
        else 
            System.out.println(wMoney + "원 인출"); // 잔금이 1000원보다 큰 경우

        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}
