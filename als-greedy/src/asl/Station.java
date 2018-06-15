
package asl;

/**
 * @author MarceloFCandido, rubiotorres, gabrieldutra
 */
public class Station {
    
    private String name;
    private int procTime;
    
    public Station(String name, int time) {
        this.name = name;
        this.procTime = time;
    }
    
    public void setProcTime(int time) {
        this.procTime = time;
    }
    
    public int getProcTime() {
        return this.procTime;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
}
