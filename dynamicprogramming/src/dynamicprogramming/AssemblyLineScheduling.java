package trabalhopratico2;
/*
    A programaçao dinamica leva em conta caminhos traçados anteriormente,
    monta-se uma uma "tabela" de resultados anteriores.
*/
import java.util.*;

public class AssemblyLineScheduling {

    public AssemblyLineScheduling() {
    }
    
    

    void LinhaMontagePD(int[]a1,int[]a2,int[]t1,int[]t2, int e1, int e2,int x1, int x2) {
        
        int n=a1.length;
        
        int  f, l, k;
        int[] f1, f2, l1, l2;
        f1 = new int[n];
        f2 = new int[n];
        l1 = new int[n];
        l2 = new int[n];
        f1[0] = e1 + a1[0];
        f2[0] = e2 + a2[0];
        System.out.println("Estação 1 - Tempos:");
        System.out.print("Estação: ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1)+" " );
        }
        System.out.print("\nTempo: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a1[i]+" " );
        }
        System.out.println("\nEstação 2 - Tempos:");
        System.out.print("Estação: ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1)+" ");
        }
        System.out.print("\nTempo: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a2[i]+" ");
        }

        for (int j = 1; j < n; j++) {// Parte iterativa da progDinmica que armazena em F11 e F2 os caminhos possiveis
            if ((f1[j - 1] + a1[j]) <= (f2[j - 1] + t2[j - 1] + a1[j])) {
                f1[j] = f1[j - 1] + a1[j];
                l1[j] = 1;
            } else {
                f1[j] = f2[j - 1] + t2[j - 1] + a1[j];
                l1[j] = 2;
            }
            if ((f2[j - 1] + a2[j]) <= (f1[j - 1] + t1[j - 1] + a2[j])) {
                f2[j] = f2[j - 1] + a2[j];
                l2[j] = 2;
            } else {
                f2[j] = f1[j - 1] + t1[j - 1] + a2[j];
                l2[j] = 1;
            }
        }

        if (f1[n-1] + x1 < f2[n-1] + x2) {
            f = f1[n-1] + x1;
            l = 1;
        } else {
            f = f2[n-1] + x2;
            l = 2;
        }
        System.out.println();
        System.out.println("Tempos e1=" + e1 + " e2=" + e2);
        System.out.println("Tempos de Saida x1=" + x1 + " x2=" + x2);
        System.out.println();
        System.out.println("Tempo Ótimo: " + f);

        System.out.println("\n----------Caminho Ótimo----------\n");
        k = l;
        System.out.println("Linha " + l + " Estação " + n);
        for (int j = n-1; j >= 1; j--) {

            if (k == 1) {
                k = l1[j];
                System.out.println("Linha " + k + " Estação " + (j) + " ");
            } else {
                k = l2[j];
                System.out.println("linha " + k + " Estação " + (j) + " ");
            }
        }
        System.out.println();

    }    
    public static int LinhaMontagem(int[]a1,int[]a2,int[]t1,int[]t2, int e1, int e2,int x1, int x2){
        int n = a1.length-1;
        return Math.min(LinhaMontagemRec(a1,a2,t1,t2, e1,e2, x1,x2, n, 0) + x1, 
                                LinhaMontagemRec(a1,a2,t1,t2, e1,e2, x1,x2, n, 1) + x2);
    }

    public static int LinhaMontagemRec(int[]a1,int[]a2,int[]t1,int[]t2, int e1, int e2,int x1, int x2, int n, int line){  
    if(n == 0){
        if(line==0){
           return e1 + a1[0];  
        }else if(line==1){
            return e2 + a2[0];
        }
         
    }  

    int T0 = Integer.MAX_VALUE;  
    int T1 = Integer.MAX_VALUE;  
    if(line == 0){      
        T0 = Math.min(LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 0) + a1[n],             
                            LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 1) + t2[n] + a1[n]);    
    }else if(line == 1){       
        T1 = Math.min(LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 1) + a2[n],             
                             LinhaMontagemRec(a1,a2,t1, t2, e1,e2, x1,x2, n-1, 0) + t1[n] + a2[n]);   
    }  

    return Math.min(T0, T1);  
} 
}
