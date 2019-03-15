package ds.linkedlist;

import org.omg.PortableInterceptor.INACTIVE;

public class MyLinkedList<T> {
    Node head;

    public MyLinkedList() {
    }

    private void add(int i){
        Node<Integer> node = new MyLinkedList.Node(i);
        if(head ==null){
            head = node;
        }else{
            Node<Integer> temp = head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
    }

    //insert i after j node
    private void insert(int i, int j){
        Node<Integer> node = new MyLinkedList.Node(i);

        Node<Integer> temp = head;
        while(temp.next!=null){
            if(temp.value==j){
                break;
            }
            temp=temp.next;
        }

        node.next = temp.next;
        temp.next=node;
    }

    //update i with j node
    private void update(int i, int j){
        Node<Integer> temp = head;
        while(temp.next!=null){
            if(temp.value==i){
                temp.value=j;
                break;
            }
            temp=temp.next;
        }
    }

    private void delete(int i){
        Node<Integer> temp = head;
        Node<Integer> prev = head;
        while(temp.next!=null){
            if(temp.value==i){
                break;
            }
            prev=temp;
            temp=temp.next;
        }

        if(temp==head){
            head=temp.next;
            temp=null;
        }else {
            prev.next = temp.next;
            temp = null;
        }
    }

    private static void print(MyLinkedList<Integer> list){
        Node<Integer> n = list.head;
        while(n !=null){
            System.out.println(n.value);
            n = n.next;
        }
    }


    static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        print(list);
        list.insert(15, 10);
        list.insert(25, 20);
        System.out.println("after insert: ");
        print(list);

        list.update(15, 16);
        System.out.println("after update: ");
        print(list);
        list.delete(20);
        list.delete(10);
        System.out.println("after delete: ");
        print(list);
    }
}
