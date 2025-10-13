package Scheduler;

public class SchedulerSRJF extends Scheduler{
    public SchedulerSRJF(){
        super();
        setPolitica(POLITICA.SRJF);
    }

    @Override
    public Proces getCurrentProces(){
        return getShortestRemainigProces();
    }

    public Proces getShortestRemainigProces(){
        Proces shortest = null;
        int minCicles = Integer.MAX_VALUE;
        for(int i=0; i<numProcesos; i++){
            if(procesos[i].numPendingCicles< minCicles){
                minCicles = procesos[i].numPendingCicles;
                shortest = procesos[i];
            }
        }
        return shortest;
    }

}
