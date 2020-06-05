package hackerrank;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/compare-two-linked-lists/problem?isFullScreen=true

public class CompareLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the compareLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if(head1 == null || head2 == null) return false;
        int first = getCount(head1);
        int second = getCount(head2);

        if(first != second) return false;
        else{
            while(head1!=null){
                if(head1.data != head2.data)return false;
                head1 = head1.next;
                head2 = head2.next;
            }
            return true;
        }

    }
    private static int getCount(SinglyLinkedListNode head){
        int length=0;
        while(head!=null){
            head = head.next;
            length++;
        } return length;
    }

    private static final Scanner scanner = new Scanner(System.in);