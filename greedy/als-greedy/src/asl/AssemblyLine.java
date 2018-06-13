
package asl;

import java.util.ArrayList;

/**
 * @author MarceloFCandido, rubiotorres, gabrieldutra
 */
public class AssemblyLine {
    
    private final int inProcTime, outProcTime;
    private int nStations;
    ArrayList<Station> stations;
    
    public AssemblyLine(int inProcTime, int nStations, int outProcTime) {
        this.inProcTime = inProcTime;
        this.nStations = nStations;
        this.outProcTime = outProcTime;
    }
    
    public void setNStations(int n) {
        this.nStations = n;
    }
    
    public int getProcTime() {
        return this.nStations;
    }
    
    public void createNewStation(int time) {
        stations.add(new Station(time));
    }
    
}
