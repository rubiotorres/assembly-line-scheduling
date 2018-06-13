
package asl;

/**
 * @author MarceloFCandido, rubiotorres, gabrieldutra
 */
public class Station {
    
    private int procTime;
    
    public Station(int time) {
        this.procTime = time;
    }
    
    public void setProcTime(int time) {
        this.procTime = time;
    }
    
    public int getProcTime() {
        return this.procTime;
    }
    
}
