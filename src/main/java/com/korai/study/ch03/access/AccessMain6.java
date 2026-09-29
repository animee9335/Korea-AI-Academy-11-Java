package com.korai.study.ch03.access;

import com.korai.study.ch03.access.entity.Role;

// public class AccessMain6 파일명과 이름이 동일한 class만 public을 붙일 수 있다.
public class AccessMain6 {
    public static void main(String[] args) {
        AccessMain6 accessMain6 = new AccessMain6();
        accessMain6.run();
    }

    void run() {
        AccessMain4.main(null);
        Role role = new Role();
        role.name = "빵";
        System.out.println(role.name);
    }
}
