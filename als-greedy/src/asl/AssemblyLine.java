
package asl;

import java.util.ArrayList;

/**
 * @author MarceloFCandido, rubiotorres, gabrieldutra
 */
public class AssemblyLine {
    
    private String name;
    private final int inProcTime, outProcTime;
    private int nStations;
    private ArrayList<Station> stations = new ArrayList<Station>();
    
    public AssemblyLine(String name, int inProcTime, int nStations, int outProcTime) {
        this.name = name;
        this.inProcTime = inProcTime;
        this.nStations = nStations;
        this.outProcTime = outProcTime;
    }
    
    public void setNStations(int n) {
        this.nStations = n;
    }
    
    public int getNStations() {
        return this.nStations;
    }
    
    public int getInProcTime() {
        return this.inProcTime;
    }
    
    public int getOutProcTime() {
        return this.outProcTime;
    }
    
    public void createNewStation(String name, int time) {
        this.stations.add(new Station(name, time));
    }
    
    public int getProcTimeOfStation(int station) {
        return this.stations.get(station).getProcTime();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getNameOfStation(int station) {
        return this.stations.get(station).getName();
    }
    
}
