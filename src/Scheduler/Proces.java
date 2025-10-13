package Scheduler;

import processing.core.PApplet;

public class Proces {


    enum ESTAT {WAITING, RUNNING, FINISHED};
    ESTAT estat;
    int numCiclesCPU;
    int numPendingCicles;
    String nom;

    public Proces(String nom, int nc) {
        this.nom = nom;
        this.numCiclesCPU = nc;
        this.numPendingCicles = nc;
        this.estat = ESTAT.WAITING;
    }

    public void run(){
        this.estat = ESTAT.RUNNING;
        this.numPendingCicles--;
        if(this.numPendingCicles==0){
            this.estat = ESTAT.FINISHED;
        }
    }

    public void display(PApplet p5, float x, float y, float w, float h){
        p5.pushStyle();
        if(estat == ESTAT.WAITING){
            p5.fill(110);
        } else if (estat == ESTAT.RUNNING) {
            p5.fill(220, 50, 50);
        }
        p5.stroke(0);
        p5.rect(x,y,w,h,5);

        p5.fill(0);
        p5.textAlign(p5.CENTER); p5.textSize(24);
        p5.text(numPendingCicles+"/"+numCiclesCPU,x + w/2, y + 2*h/3);
        p5.popStyle();
    }

}
