package JavaProject;

class Cube {
    private int width;  // 가로
    private int height; // 세로
    private int depth;  // 높이

    // 생성자: 가로, 세로, 높이를 받아 초기화
    public Cube(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // 큐브의 부피를 반환하는 메서드
    public int getVolume() {
        return width * height * depth;
    }

    // 가로, 세로, 높이를 각각 증가시키는 메서드
    public void increase(int widthIncrement, int heightIncrement, int depthIncrement) {
        this.width += widthIncrement;
        this.height += heightIncrement;
        this.depth += depthIncrement;
    }

    // 부피가 0인지 확인하는 메서드
    public boolean isZero() {
        return width == 0 || height == 0 || depth == 0;
    }

    // main 메서드
    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3); // 가로, 세로, 높이가 1, 2, 3인 큐브 객체 생성
        System.out.println("큐브의 부피는 " + cube.getVolume()); // 6 출력
        cube.increase(1, 2, 3); // 가로, 세로, 높이 각각 1, 2, 3씩 증가
        System.out.println("큐브의 부피는 " + cube.getVolume()); // 48 출력
        if (cube.isZero()) {
            System.out.println("큐브의 부피는 0");
        } else {
            System.out.println("큐브의 부피는 0이 아님");
        }
    }
}
