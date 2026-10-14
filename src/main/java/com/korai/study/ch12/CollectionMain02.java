package com.korai.study.ch12;

import lombok.AllArgsConstructor;

public class CollectionMain02 {
    public static void main(String[] args) {
        CustomLinkedList<String> list1 = new CustomLinkedList();
        list1.add("자바1");
        list1.add("자바2");
        list1.add("자바3");
        list1.add("자바4");
        System.out.println(list1);
        System.out.println(list1.get(0));

//        list1.remove(1);
        System.out.println(list1.remove(1));
        System.out.println(list1);

        list1.set(1, "파이썬");
        System.out.println(list1);

        list1.insert(2, "자바5");
        System.out.println(list1);
        list1.insert(4, "자바6");
        System.out.println(list1);
        list1.insert(0, "자바7");
        System.out.println(list1);

    }
}

/*
* LinkedList -> 선형리스트(단방향)
* 노드를 연결한다.
* 노드란? 연결된 다른 노드들의 주소와 저장할 값을 포함한 것
* */

    class CustomLinkedList<E> {
        @AllArgsConstructor
        private static class Node<E> {
            E item;
            Node<E> next;
        }

        private Node<E> head;
        private Node<E> tail ;
        private int size;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node<E> current = head;
            for (int i = 0; i < size; i++) {
                builder.append(current.item);
                if (i != size - 1) {
                    builder.append(", ");
                }
                current = current.next;
            }
            builder.append("]");

            return builder.toString();
        }

        public void add(E e) {
            Node<E> newNode = new Node<>(e, null);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public E get(int n) {
            if(!(n < size) && (n > -1)) {
                throw new IndexOutOfBoundsException("인덱스 범위를 초과하였습니다");
            }
            Node<E> current = head;
            for (int i = 0; i < n; i++) {
                current = current.next;
            }
            return current.item;

        }

        public E remove(int n) {
            if(!(n < size) && (n > -1)) {
                throw new IndexOutOfBoundsException("인덱스 범위를 초과하였습니다");
            }
            Node<E> removed;
            // 첫번째 노드 삭제
            if (n == 0) {
                removed = head;
                head = head.next;
                if (head == null) { // 노드가 하나일 때 삭제
                    tail = null;
                }
            } else {
                Node<E> prev = head;
                for (int i =0; i < n - 1; i++) { // 삭제하는 노드의 이전까지 이동
                    prev = prev.next;
                }
                removed = prev.next; // removed에 다음 노드의 주소를 저장
                prev.next = removed.next; // 다음 노드의 주소에 그 다음 노드의 주소를 저장
                if (removed.next == null) { // 마지막 노드를 삭제할 때
                    tail = prev; // tail을 앞 노드로 이동
                }
            }
            size--;
            return removed.item;
        }

        public void set(int n, E e) {
            if(!(n < size) && (n > -1)) {
                throw new IndexOutOfBoundsException("인덱스 범위를 초과하였습니다");
            }
            Node<E> current = head;
            for (int i = 0; i < n; i++) {
                current = current.next;
            }
            current.item = e;
        }

        public void insert(int n, E e) {
            Node<E> newNode = new Node<>(e, null);

            if(n == size) { // 마지막 노드 삽입
                add(e);
                return;
            }

            if (n == 0) { // 첫번째 노드 삽입
                newNode.next = head;
                head = newNode;
            } else {
                Node<E> prev = head;
                for (int i =0; i < n - 1; i++) { // 수정하고자하는 노드 이전까지 이동, 중간 노드 삽입
                    prev = prev.next;
                }
                newNode.next = prev.next;
                prev.next = newNode;
            }
            size++;
        }
    }
