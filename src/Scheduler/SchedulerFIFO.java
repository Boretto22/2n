package Scheduler;

public class SchedulerFIFO extends Scheduler{

    public SchedulerFIFO(){
        super();
        setPolitica(POLITICA.FIFO);

    }

    @Override
    public Proces getCurrentProces() {
        return procesos[0];
    }
}
