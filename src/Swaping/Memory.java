package Swaping;

import processing.core.PApplet;

public class Memory{

    int mida;
    Process[] procesos;
    int numProcesos;
    int freeAddress;
    int MemoriaOcupada = 0;

    Memory(int m){
        this.mida = m;
        procesos = new Process[100];
        numProcesos = 0;
        freeAddress = 0;

    }

    void swapIn(Process p){

        if (freeAddress +p.mida < mida) {
            procesos[numProcesos] = p;
            numProcesos++;
            p.setAddress(freeAddress);
            freeAddress += p.mida;
        }
        else{
            System.out.println("Error SWAP In del procés "+p.nom+"!");
        }
    }

    void swapOut(Process p){
        for(int i=0; i<numProcesos; i++){
            if(procesos[i]==p){
                procesos[i]=null;
                numProcesos --;
                System.out.println("SWAPPED OUT " + p.nom);
            }
        }
    }

    void display(PApplet p5) {

        p5.strokeWeight(3);
        p5.stroke(0);
        p5.fill(220);
        p5.rect(100, 100, mida, 300);

        p5.stroke(0);
        p5.strokeWeight(3);
        p5.fill(0);
        p5.textSize(20);
        p5.textAlign(p5.LEFT);
        p5.text("Memòria RAM", 100, 90);
        p5.text("Total: " + mida, 100, 400);

        for (int i = 0; i < procesos.length; i++) {

            if (procesos[i] != null) {
                procesos[i].display(p5, 100, 100, 300);
            }
        }

        int calculaMemoriaOcupada (MemoriaOcupada) {
        for (int i = 0; i < procesos.length; i++) {
            MemoriaOcupada = MemoriaOcupada + procesos[i];
        }
    }
        
}
