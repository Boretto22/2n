package Swaping;

import processing.core.PApplet;

public class swapping extends PApplet {

    Process p0, p1, p2, p3, p4;
    Memory memory;

    public static void main(String[] args) {
        PApplet.main("Swaping.swapping");
    }


    public void settings(){
        size(1400, 800);
    }

    public void setup(){

        memory = new Memory(1024);

        p0 = new Process("SO", color(255,0,0), 512);
        p1 = new Process("P1", color(0,255,0), 64);
        p2 = new Process("P2", color(0,0,255), 128);
        p3 = new Process("P3", color(100,100,100), 256);
        p4 = new Process("P4", color(100,200,50), 128);

        memory.swapIn(p0);
    }

    public void draw(){
        background(255);
        memory.display(this);

        if(frameCount == 100) {
            memory.swapIn(p1);
        }
        else if(frameCount == 200) {
            memory.swapIn(p2);
        }
        else if(frameCount == 300) {
            memory.swapIn(p3);
        }
        else if(frameCount == 400){
            memory.swapOut(p1);
        }
        else if(frameCount == 500) {
            memory.swapIn(p4);
        }
    }

}
