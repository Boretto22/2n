package Nodes;

import processing.core.PApplet;

public class Node {

    int valor;
    Node seg;

    public Node(int v){
        this.valor = v;
        this.seg = null;
    }

    public Node(int v, Node sn){
        this.valor = v;
        this.seg = sn;
    }

    public int getValor(){
        return this.valor;
    }
    public Node getSeg(){
        return this.seg;
    }

    void display(PApplet p5, float x, float y, float w){

        p5.fill(255);
        p5.rect(x, y, w, w);

        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(this.valor, x + w/2, y + w/2 + 10);

        if(this.seg!=null){
            p5.line(x + w, y + w/2, x + 2*w, y +w/2);
            p5.fill(0);
            p5.triangle(x + 2*w, y +w/2,
                    x + 2*w - w/4, y +w/2 - w/4,
                    x + 2*w - w/4, y +w/2 + w/4);
        }
        else {
            p5.line(x + w/2, y + w, x + w/2, y + 2*w);
            p5.circle(x + w/2, y + 2*w, 10);
            p5.text("TAIL", x + w/2, y + 2*w + 50);
        }
    }
}
