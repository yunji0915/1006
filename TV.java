package JavaProject;

class TV {
    private String brand;
    private int size;
    private int price;

    // 생성자
    public TV(String brand, int size, int price) {
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    // 정보를 출력하는 메서드
    public void show() {
        System.out.println(brand + "에서 만든 " + price + "만원짜리의 " + size + "인치 TV");
    }

    // main 메서드
    public static void main(String[] args) {
        TV tv = new TV("Samsung", 50, 300); // 300만원짜리 Samsung에서 만든 50인치 TV
        tv.show();
    }
}
