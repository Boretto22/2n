package Scheduler;

import processing.core.PApplet;

public class MainSchedulerSJF extends PApplet {

    Proces p1, p2, p3;
    SchedulerSJF scheduler;

    public static void main(String[] args) {
        PApplet.main("Scheduler.MainSchedulerSJF");
    }

    public void settings(){
        size(1400, 800);
    }

    public void setup(){

        p1 = new Proces("P1", 6);
        p2 = new Proces("P2", 2);
        p3 = new Proces("P3", 4);

        scheduler = new SchedulerSJF();

        scheduler.enterProces(p1);
        scheduler.enterProces(p2);
        scheduler.enterProces(p3);

    }

    public void draw(){

        background(255);
        scheduler.display(this, 100, 100, 100);

    }


    public void keyPressed(){
        if(key=='r'){
            scheduler.run();
        }
    }
}

