package Swaping.Versio1;

import processing.core.PApplet;

public class swapping extends PApplet {

    Proces p0, p1, p2, p3, p4;

    Memory memory;

    public static void main(String[] args) {
        PApplet.main("Swapping.Versio1.Swapping");
    }

    public void settings() {
        size(1400,800);

    }

    public void setup() {

        p0 = new Proces("SO", color(0, 0, 255), 512);
        p1 = new Proces("P1", color(255,0,0), 64);
        p2 = new Proces("P2", color(255, 255, 0), 128);
        p3 = new Proces("P3", color(255, 0, 255), 256);
        p4 = new Proces("P4", color(0, 255, 255), 128);



        memory = new Memory(1024);

        memory.swapIn(p0);

    }

    public void draw(){
        background(255);
        memory.display(this);

        if(frameCount == 100){
            memory.swapIn(p1);
        }
        if(frameCount == 200){
            memory.swapIn(p2);
        }
        if(frameCount == 300){
            memory.swapIn(p3);
        }
        if(frameCount == 400){
            memory.swapOut(p1);
        }
        if(frameCount == 500){
            memory.swapIn(p4);
        }






    }
}