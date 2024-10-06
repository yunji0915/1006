package JavaProject;

class Rectangle {
    private int x, y;       // 사각형의 왼쪽 위 모서리의 좌표
    private int width, height;  // 사각형의 너비와 높이

    // x, y, width, height를 매개변수로 받아 필드를 초기화하는 생성자
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 사각형 정보를 출력하는 메서드
    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    // 사각형이 정사각형이면 true, 아니면 false를 반환하는 메서드
    public boolean isSquare() {
        return width == height;
    }

    // 현재 사각형 내부에 매개변수로 받은 사각형 r이 있으면 true, 아니면 false를 반환하는 메서드
    public boolean contains(Rectangle r) {
        return (this.x <= r.x) && (this.y <= r.y) && 
               (this.x + this.width >= r.x + r.width) && 
               (this.y + this.height >= r.y + r.height);
    }

    // main 메서드
    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 3, 6, 6);
        Rectangle b = new Rectangle(4, 4, 2, 3);

        a.show();
        if(a.isSquare()) 
            System.out.println("a는 정사각형입니다.");
        else 
            System.out.println("a는 직사각형입니다.");
        
        if(a.contains(b)) 
            System.out.println("a는 b를 포함합니다.");
    }
}
