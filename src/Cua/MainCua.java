package Cua;

import processing.core.PApplet;

import static java.lang.Math.random;

public class MainCua extends PApplet{

    Cua c;
    int lastOut = -1;
    int lastIn = -1;

    void setup(PApplet p5){
        p5.size(800,800);
        c = new Cua();
    }

    void draw(PApplet p5){
        p5.background(100, 255,100);
        c.display(p5,50,100);

        p5.textSize(54); p5.textAlign(p5.LEFT);
        p5.text("CUA (QUEUE)", 100, 400);

        p5.textSize(34);
        p5.text("Núm. Elements: "+c.numElements(), 100, 500);
        p5.text("Empty: "+c.isEmpty(), 100, 550);
        p5.text("Full: "+c.isFull(), 100, 600);
        p5.text("Last Dequeued: "+lastOut, 100, 650);
        p5.text("Last Enqueued: "+lastIn, 100, 700);
    }

    public void keyPressed(){
        if(key=='a'){
            if(!c.isFull()){
                lastIn = (int)random(0, 100);
                c.encola(lastIn);
                println("ENQUEUE: "+lastIn);
            }
            else {
                println("NO ENQUEUE, Queue is full!!");
            }
        }
        else if(key=='r'){
            if(!c.isEmpty()){
                lastOut = c.desencola();
                println("DEQUEUE: "+lastOut);
            }
            else {
                println("NO DEQUEUE, Queue is empty!!");
            }
        }
    }
}
