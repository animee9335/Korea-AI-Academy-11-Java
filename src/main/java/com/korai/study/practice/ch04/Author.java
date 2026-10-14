package com.korai.study.practice.ch04;

import lombok.*;

@Data // get, set, eq, hc, toString
public class Author {
    private String name;
    private String birthday;

//    @NoArgsConstructor
    public Author() {

    }

    public Author(String name) {
        this.name = name;
    }

//    @AllArgsConstructor
    public Author(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    // 같은 자료형이면 어떤값이 대입이 되어야할지 모르기 때문에 사용 불가
//    public Author(String birthday) {
//        this.name = birthday;
//    }

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    class Publisher {
        private final String name;
        private final String adress;
        private String adress2;

        //    @RequiredArgsConstructor // 필수로 들어가야하는 것, final
//        public Publisher(String name) {
//            this.name = name;
//        }
    }
}

class authorMain {
    public static void main(String[] args) {
        Author a = new Author();
        Author.Publisher p = a.new Publisher("한빛 미디어", "부산");
        Author.Publisher p2 = a.new Publisher("한빛 미디어", "부산", "부산진구");
    }
}
