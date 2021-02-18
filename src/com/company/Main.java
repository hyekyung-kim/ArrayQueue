package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;


class Queue{
    int front;
    int rear;
    int qSize;
    int[] array;

    Queue(int front, int rear, int qSize){
        this.front = front;
        this.rear = rear;
        this.qSize = qSize;
        array = new int[qSize];
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == qSize;
    }

    public void enQueue(int element){
        if(isFull()) {
            System.out.println("Queue is FULL\n");
        }else{
            array[rear++] = element;
        }
    }

    public int deQueue(){
        if(!isEmpty()){
            return array[front++];
        }else{
            System.out.println("Queue is EMPTY\n");
            return -1;
        }
    }

    public void printQueue(){
        System.out.println(front + " ~ " + rear);

        IntStream.range(front, rear).forEach((int i)
                -> System.out.print(array[i] + " "));

        System.out.println();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 큐의 크기
        System.out.print("Max queueSize: ");
        int qSize = input.nextInt();

        // 큐 생성 & 초기화
        Queue queue = new Queue(0, 0, qSize);

        // 큐 정보 입력
        System.out.println("\nMENU (0: restart | 1: enQueue | 2: deQueue | 3: print queue | -1: quit)\n");
        int check;
        do{
            System.out.print("what do you want? ");
            check = input.nextInt();

            // 재시작
            if(check == 0){
                System.out.println("Init queue and restart");
                System.out.print("Max queueSize: ");
                qSize = input.nextInt();

                queue = new Queue(0, 0, qSize);
            } // queue 삽입
            else if(check == 1) {
                System.out.print("Input queue element: ");
                int tmp = input.nextInt();
                queue.enQueue(tmp);
            } // queue 삭제
            else if(check == 2){
                System.out.println("Get element from queue: " + queue.deQueue());
            } // 출력
            else if(check == 3){
                queue.printQueue();
            } // 종료
            else if(check == -1){
                System.out.println("exit...");
            } // 예외
            else{
                System.out.println("Command not found.\n");
            }

        } while(check != -1);
    }
}
