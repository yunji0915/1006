package JavaProject;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"};
    private static String[] eng = {"love", "baby", "money", "future", "hope"};

    // 한글 단어를 영어로 변환하는 메서드
    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) { // 입력된 단어와 배열의 단어 비교
                return eng[i]; // 일치하는 경우 영어 단어 반환
            }
        }
        return null; // 일치하는 단어가 없는 경우 null 반환
    }
}
