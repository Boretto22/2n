package Swaping;

import processing.core.PApplet;

public class Process {

    String nom;
    int color;
    int mida;
    int address;

    Process(String n, int c, int m){
        this.nom = n;
        this.color = c;
        this.mida = m;
    }

    public void setAddress(int a) {
        this.address = a;
    }

    void display(PApplet p5, float x, float y, float h){
        p5.fill(this.color);
        p5.stroke(0); p5.strokeWeight(3);
        p5.rect(x + this.address, y, this.mida, h);

        p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(20);
        p5.text(this.nom, x + this.address + this.mida/2, y + h/2);

    }
}
