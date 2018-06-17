
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

/**
 *
 * @author JoãoPedro
 */
public class Dynamicprogramming {
    
    public static void main(String[] args) {
        int[] t1 = {3,5,4,2,7,5,8,1};
        int[] t2 = {5,3,7,5,6,2,5,2};
        int[] a1 = {5,7,10,5,9,11,9,5,2};
        int[] a2 = {6,3,9,11,4,9,3,12,4};
        int x1, x2, e1, e2,e3,e4,x3,x4;
         e1 = 3; e2 = 2; x1 = 6; x2 = 5; 
        
        System.out.println("-----------------PROBLEMA 1----------");

        AssemblyLineScheduling Linha1 = new AssemblyLineScheduling();
        Linha1.LinhaMontagePD(a1,a2,t1,t2,e1,e2,x1,x2);
        
        System.out.println("");
        System.out.println("-----------------PROBLEMA 2----------");
        System.out.println("");
        int[] t3 = {4,2,7,2,5,8,2};
        int[] t4 = {6,1,7,3,6,4,5};
        int[] a3 = {10,6,3,8,5,3,7,12};
        int[] a4 = {3,5,3,7,6,4,9,10};
         e3 = 5; e4 = 7; x3 = 8; x4 = 9;
        
        AssemblyLineScheduling Linha2 = new AssemblyLineScheduling();
        Linha2.LinhaMontagePD(a3,a4,t3,t4,e3,e4,x3,x4);
       
    }
    
}
