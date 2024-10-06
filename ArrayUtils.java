package JavaProject;


class ArrayUtils {
    // 두 배열을 연결하여 새로운 배열을 리턴
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length]; // 두 배열의 길이를 합친 크기의 새로운 배열 생성
        
        // 첫 번째 배열 복사
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        
        // 두 번째 배열 복사
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i]; // a 배열 뒤에 b 배열 요소 추가
        }
        
        return result; // 새로운 배열 리턴
    }
    
    // 배열 출력
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " "); // 각 요소를 출력
        }
        System.out.println(); // 줄 바꿈
    }
}