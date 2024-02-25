package Synchronized_Keyword_Notes;

public class SyncDemo {
    int ctr = 0;
    public synchronized void counter(){ // Removing the synchronized would make a "bug" which outputs undesired number
        this.ctr++;
    }
}
