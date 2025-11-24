package Pila;

import processing.core.PApplet;

public class Pila {

    int[] array;    // Dades
    int top;        // Utilitat de gestió

    public Pila(){
        array = new int[10];
        top = -1;
    }

    public void push(int n){
        top ++;
        array[top] = n;
    }

    int pop(){
        top --;
        return array[top+1];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == array.length-1;
    }

    public int numElements(){
        return top+1;
    }

    void display(PApplet p5, int x, int y){
        float r = 70; p5.strokeWeight(3);
        for(int i=array.length-1; i>=0; i--){
            p5.fill(0); p5.textSize(24);
            p5.text(i, x - r/1.5f, y + (array.length - i - 1)*r + r/2);
            p5.fill(255);
            p5.rect(x, y + i*r, r,r);
        }

        for(int i=array.length-1; i>=0; i--){
            if(i<=top){
                p5.fill(255,0,0); p5.textSize(24); p5.textAlign(p5.CENTER);
                p5.text(array[i],  x + r/2.2f, y + (array.length - i - 1)*r + r/2);
            }
        }

        p5.fill(0); p5.textSize(32); p5.textAlign(p5.LEFT);
        p5.text("<-- Top("+top+")", x + r*1.2f, y + (array.length - top -1)*r + r/2);
    }

}
