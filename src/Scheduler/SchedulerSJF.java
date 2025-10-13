package Scheduler;

public class SchedulerSJF extends Scheduler {

    public SchedulerSJF(){
        super();
        setPolitica(POLITICA.SJF);
    }

    public Proces getCurrentProces(){
        return getShortestProces();
    }

    public Proces getShortestProces(){
        Proces shortest = null;
        int minCicles = Integer.MAX_VALUE;
        for(int i=0; i<numProcesos; i++){
            if(procesos[i].numCiclesCPU< minCicles){
                minCicles = procesos[i].numCiclesCPU;
                shortest = procesos[i];
            }
        }
        return shortest;
    }

}