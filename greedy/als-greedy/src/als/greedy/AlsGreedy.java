
package als.greedy;

import asl.*;

/**
 * @author MarceloFCandido, rubiotorres, gabrieldutra
 */
public class AlsGreedy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int [] T1 = null, T2 = null;
        int time = 0, actualLine;
        
        int instance = 1;
        
        // Instancia 01
        int inl11 = 3;
        
        Station s111 = new Station("s111", 5);
        Station s112 = new Station("s112", 7);
        Station s113 = new Station("s113", 10);
        Station s114 = new Station("s114", 5);
        Station s115 = new Station("s115", 9);
        Station s116 = new Station("s116", 11);
        Station s117 = new Station("s117", 9);
        Station s118 = new Station("s118", 5);
        Station s119 = new Station("s119", 2);
        
        int outl11 = 6;
        
        int inl12 = 2;
        
        Station s121 = new Station("s121", 6);
        Station s122 = new Station("s122", 3);
        Station s123 = new Station("s123", 9);
        Station s124 = new Station("s124", 11);
        Station s125 = new Station("s125", 4);
        Station s126 = new Station("s126", 9);
        Station s127 = new Station("s127", 3);
        Station s128 = new Station("s128", 12);
        Station s129 = new Station("s129", 4);
        
        int outl12 = 5;
        
        // Instancia 02
        int inl21 = 5;
        
        Station s211 = new Station("s211", 10);
        Station s212 = new Station("s212", 6);
        Station s213 = new Station("s213", 3);
        Station s214 = new Station("s214", 8);
        Station s215 = new Station("s215", 5);
        Station s216 = new Station("s216", 3);
        Station s217 = new Station("s217", 7);
        Station s218 = new Station("s218", 12);
        
        int outl21 = 8;
        
        int inl22 = 7;
        
        Station s221 = new Station("s221", 3);
        Station s222 = new Station("s222", 5);
        Station s223 = new Station("s223", 3);
        Station s224 = new Station("s224", 7);
        Station s225 = new Station("s225", 6);
        Station s226 = new Station("s226", 4);
        Station s227 = new Station("s227", 9);
        Station s228 = new Station("s228", 10);
        
        int outl22 = 9;
        
        AssemblyLine al1 = null;
        AssemblyLine al2 = null;
        
        if (instance == 1) {
            al1 = new AssemblyLine("al1", inl11, 9, outl11);
            al1.createNewStation(s111.getName(), s111.getProcTime());
            al1.createNewStation(s112.getName(), s112.getProcTime());
            al1.createNewStation(s113.getName(), s113.getProcTime());
            al1.createNewStation(s114.getName(), s114.getProcTime());
            al1.createNewStation(s115.getName(), s115.getProcTime());
            al1.createNewStation(s116.getName(), s116.getProcTime());
            al1.createNewStation(s117.getName(), s117.getProcTime());
            al1.createNewStation(s118.getName(), s118.getProcTime());
            al1.createNewStation(s119.getName(), s119.getProcTime());
            
            T1 = new int[] {3, 5, 4, 2, 7, 5, 8, 1};
            
            al2 = new AssemblyLine("al2", inl12, 9, outl12);
            al2.createNewStation(s121.getName(), s121.getProcTime());
            al2.createNewStation(s122.getName(), s122.getProcTime());
            al2.createNewStation(s122.getName(), s123.getProcTime());
            al2.createNewStation(s122.getName(), s124.getProcTime());
            al2.createNewStation(s122.getName(), s125.getProcTime());
            al2.createNewStation(s122.getName(), s126.getProcTime());
            al2.createNewStation(s122.getName(), s127.getProcTime());
            al2.createNewStation(s122.getName(), s128.getProcTime());
            al2.createNewStation(s122.getName(), s129.getProcTime());
            
            T2 = new int[] {5, 3, 7, 5, 6, 2, 5, 2};
            
        } else if (instance == 2) {
            al1 = new AssemblyLine("al1", inl21, 8, outl21);
            al1.createNewStation(s211.getName(), s211.getProcTime());
            al1.createNewStation(s212.getName(), s212.getProcTime());
            al1.createNewStation(s213.getName(), s213.getProcTime());
            al1.createNewStation(s214.getName(), s214.getProcTime());
            al1.createNewStation(s215.getName(), s215.getProcTime());
            al1.createNewStation(s216.getName(), s216.getProcTime());
            al1.createNewStation(s217.getName(), s217.getProcTime());
            al1.createNewStation(s218.getName(), s218.getProcTime());
            
            T1 = new int[] {4, 2, 7, 2, 5, 8, 2};
            
            al2 = new AssemblyLine("al2", inl22, 8, outl22);
            al2.createNewStation(s221.getName(), s221.getProcTime());
            al2.createNewStation(s222.getName(), s222.getProcTime());
            al2.createNewStation(s223.getName(), s223.getProcTime());
            al2.createNewStation(s224.getName(), s224.getProcTime());
            al2.createNewStation(s225.getName(), s225.getProcTime());
            al2.createNewStation(s226.getName(), s226.getProcTime());
            al2.createNewStation(s227.getName(), s227.getProcTime());
            al2.createNewStation(s228.getName(), s228.getProcTime());          
            
            T2 = new int[] {6, 1, 7, 3, 6, 4, 5};
            
        }
        
        // Starting greedy solution
        // Getting the assembly line with faster input processing time
        if (al1.getInProcTime() > al2.getInProcTime()) {
            System.out.println(al1.getName());
            System.out.println(al1.getNameOfStation(0));
            actualLine = 1;
            time += al1.getProcTimeOfStation(0) + al1.getInProcTime();
        } else {
            System.out.println(al2.getName());
            System.out.println(al2.getNameOfStation(0));
            actualLine = 2;
            time += al2.getProcTimeOfStation(0) + al2.getInProcTime();
        }
        
        // Iterating in the assembly lines's stations
        for (int i = 0; i < al1.getNStations(); i++) {
            if (actualLine == 1) {
                int auxNextStationAL = al1.getProcTimeOfStation(i + 1);
                int auxTransition = T1[i];
                int auxNextStationOL = al2.getProcTimeOfStation(i + 1);
                
                // If continuing in the actual line is slower than going to
                // the other line, go to other line. Otherwise, stay in actual
                // line
                if (auxNextStationAL > auxTransition + auxNextStationOL) {
                    actualLine = 2;
                    time += auxTransition + auxNextStationOL;
                } else {
                    actualLine = 1;
                    time += auxNextStationAL;
                }
            } else {
                int auxNextStationAL = al2.getProcTimeOfStation(i + 1);
                int auxTransition = T2[i];
                int auxNextStationOL = al1.getProcTimeOfStation(i + 1);

                if (auxNextStationAL > auxTransition + auxNextStationOL) {
                    actualLine = 1;
                    time += auxTransition + auxNextStationOL;
                } else {
                    actualLine = 2;
                    time += auxNextStationAL;
                }
                
            }
        }
        
    }
    
}
