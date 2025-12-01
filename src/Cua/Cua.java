package Cua;

import processing.core.PApplet;

public class Cua {

    int [] array;
    int last;

    public Cua(){
        array = new int[10];
        last = -1;
    }

    public void encola(int n){
        array[last + 1] = n;
        last++;
    }

    public int desencola(){
        int temp = array[0];
        for (int i=1; i<=last; i++){
            array[i-1] = array[i];
        }
        last --;
        return temp;
    }

    boolean isEmpty(){
        return last==-1;
    }

    boolean isFull(){
        return last==array.length-1;
    }

    int numElements(){
        return last+1;
    }

    void display(PApplet p5, int x, int y){
        float r = 70; p5.strokeWeight(3);
        for(int i=array.length-1; i>=0; i--){
            p5.fill(0); p5.textSize(24);
            p5.text(i, x + (array.length - i - 1)*r + r/2 , y - r/2);
            p5.fill(255);
            p5.rect(x + i*r, y , r,r);
        }

        for(int i=array.length-1; i>=0; i--){
            if(i<=last){
                p5.fill(255,0,0); p5.textSize(24); p5.textAlign(p5.CENTER);
                p5.text(array[i],  x + (array.length - i - 1)*r + r/2 , y + r/1.5f );
            }
        }

        p5.fill(0); p5.textSize(32);
        p5.text("^", x + (array.length - last -1)*r + r/2, y  + r*1.5f);
        p5.text("|", x + (array.length - last -1)*r + r/2, y  + r*1.75f);
        p5.text("Last("+last+")", x + (array.length - last -1)*r + r/2, y  + r*2.2f);
    }
}
