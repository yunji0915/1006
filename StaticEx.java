package JavaProject;

public class StaticEx { // main 메서드를 포함하는 클래스
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9}; // 첫 번째 배열
        int[] array2 = {3, 6, -1, 100, 77}; // 두 번째 배열
        
        // 두 배열을 연결한 새 배열 생성
        int[] array3 = ArrayUtils.concat(array1, array2);
        
        // 새 배열 출력
        ArrayUtils.print(array3);
    }
}