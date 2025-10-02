package Swaping.Versio2;

import processing.core.PApplet;

public class Hole {

    int address;
    int mida;

    public Hole(int a, int m){
        this.address = a;
        this.mida = m;
    }

    public void display (PApplet p5, float x, float y, float h){
        p5.fill(50); p5.stroke(0); p5.strokeWeight(3);
        p5.rect(x+address, y, mida, h);

    }
}