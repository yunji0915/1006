package JavaProject;

import java.util.Arrays;

class VArray {
    private int[] array; // 내부 배열
    private int count; // 저장된 개수

    // 생성자
    public VArray(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("초기 용량은 1 이상이어야 합니다.");
        }
        array = new int[initialCapacity];
        count = 0;
    }

    // 배열에 값 추가
    public void add(int value) {
        if (count >= array.length) {
            resize();
        }
        array[count++] = value;
    }

    // 배열 크기 변경
    private void resize() {
        array = Arrays.copyOf(array, array.length * 2); // 배열 크기 2배로 증가
    }

    // 특정 인덱스에 값 삽입
    public void insert(int index, int value) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("인덱스는 0과 " + count + " 사이여야 합니다.");
        }
        if (count >= array.length) {
            resize();
        }
        // 오른쪽으로 이동
        for (int i = count; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value; // 값 삽입
        count++;
    }

    // 특정 인덱스의 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("인덱스는 0과 " + (count - 1) + " 사이여야 합니다.");
        }
        // 왼쪽으로 이동
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        array[count - 1] = 0; // 마지막 값 제거
        count--;
    }

    // 배열의 현재 용량
    public int capacity() {
        return array.length;
    }

    // 저장된 개수 반환
    public int size() {
        return count;
    }

    // 모든 원소 출력
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
