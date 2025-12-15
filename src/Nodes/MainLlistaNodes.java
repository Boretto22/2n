package Nodes;

import processing.core.PApplet;

public class MainLlistaNodes extends PApplet{

    Node n1, n2;

    public static void main(String[] args) {
        PApplet.main("Nodes.MainLlistaNodes");
    }

    public void settings(){
        size(1600, 800);
    }

    public void setup(){
        n1 = new Node(23);
        n2 = new Node(47,n1);
    }

    public void draw(){
        background(200);
        n2.display(this, 100,100,200);
        n1.display(this,100,300,200);
    }
}
