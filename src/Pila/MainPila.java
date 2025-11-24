package Pila;

import processing.core.PApplet;

public class MainPila extends PApplet{

    Pila p;
    int lastPushed, lastPopped;

    public static void main(String[] args) {
        PApplet.main("Pila.MainPila");
    }

    public void settings(){
        fullScreen();
    }

    public void setup(){
        p = new Pila();
    }

    public void draw(){
        background(100,100);
        p.display(this,100,50);

        textSize(54);
        text("PILA (STACK)", 400, 100);

        textSize(34);
        text("Núm. Elements: "+p.numElements(), 400, 200);
        text("Empty: "+p.isEmpty(), 400, 250);
        text("Full: "+p.isFull(), 400, 300);
        text("Last Popped: "+lastPopped, 400, 350);
        text("Last Pushed: "+lastPushed, 400, 400);
    }

    public void keyPressed(){
        if(key == 'a' || key == 'A'){
            if(!p.isFull()){
                lastPushed = (int)random(0,100);
                p.push(lastPushed);
                println("PUSH: "+ lastPushed);
            } else{
                println("No PUSH, stack is full!!");
            }
        }
        if(key == 'r' || key == 'R'){
            lastPopped = p.pop();
            println("POP: "+ lastPopped);
        } else{
            println("No POP, stack is empty!!");
        }
    }


}
