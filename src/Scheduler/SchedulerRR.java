package Scheduler;

import processing.core.PApplet;

public class SchedulerRR extends Scheduler{

    int ciclesQuantum;
    int indexRR;
    int currentQuantum;

    public SchedulerRR(){
        super();
        setPolitica(POLITICA.RR);
        setCiclesQuantum(2);
    }

    public void setCiclesQuantum(int q){
        this.ciclesQuantum = q;
        this.currentQuantum = 0;
        this.indexRR = 0;
    }

    public void run(){
        Proces current = getCurrentProces();
        if(current!=null) {
            current.run();
            updateQuantum(current);
            log += "Cycle "+ numCicles + ": running " + current.nom + "\n";
            if(current.estat == Proces.ESTAT.FINISHED){
                exitProces(current);
            }
        }
        numCicles++;
    }

    void updateQuantum(Proces current){

        currentQuantum++;

        if(current.estat == Proces.ESTAT.FINISHED) {
            currentQuantum = 0;
            nextRoundRobin(true);
        }
        else if(currentQuantum == ciclesQuantum){
            procesos[indexRR].estat = Proces.ESTAT.WAITING;
            nextRoundRobin(false);
        }
    }

    public void nextRoundRobin(boolean finished){
        if(!finished) {
            indexRR++;
            if (indexRR == numProcesos) {
                indexRR = 0;
            }
        }
        else {
            System.out.println("FINISHED " + indexRR);
            if(indexRR >= numProcesos-1){
                indexRR = 0;
            }
            System.out.println("FINISHED " + indexRR);
        }
        currentQuantum = 0;
    }

    public Proces getCurrentProces(){
        return procesos[indexRR];
    }


    public void display(PApplet p5, float x, float y, float s){
        super.display(p5, x, y, s);

        p5.fill(0);
        p5.text("Quantum: "+ currentQuantum + "/" + ciclesQuantum, x, y + 80);
        p5.text("Index Round Robin: "+ indexRR, x, y + 100);
    }
}
