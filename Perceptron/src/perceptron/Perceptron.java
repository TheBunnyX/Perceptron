/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.Random;

/**
 *
 * @author Mongkol
 */
public class Perceptron {
        Random randomGenerator = new Random();
        static Perceptron P = new Perceptron();
        static int countofArray = 10;
        static PData PD;
        static PData[] P_array = new PData[countofArray];
        static int index = 0;
        static int number = 4;
        static int countround = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        P.Test();
         System.out.println("Before :");
        for(int i = 0;i <number+1;i++){
        System.out.println(" i: "+i+" bias: "+P_array[i].getbias()+" x: "+P_array[i].getx()+" y: "+P_array[i].gety()+" type: "+P_array[i].gettype());
        }
        P.updateweight();
         System.out.println("After :");
        for(int i = 0;i <number+1;i++){
        System.out.println(" i: "+i+" bias: "+P_array[i].getbias()+" x: "+P_array[i].getx()+" y: "+P_array[i].gety()+" type: "+P_array[i].gettype());
        }
        System.out.println("\nAll round : "+countround);
        System.out.println("last weight"+"{"+P_array[0].getbias()+","+P_array[0].getx()+","+P_array[0].gety()+"}\n");
    }
    public PData[] getData(){
        return P_array;
    }
    public int getIndex(){
        return index;
    }
    public void input(PData PD){
           P_array[index++] = PD; 
    }
    public void InputNumber(int A,int B,int C){
       PD = new PData(A,B,C);
       P.input(PD);
    }
    public void Test(){
    boolean check1 = false;     
    int max = 500;
    int max1 = 500; 
    for(int i = 0; i <=number; i++){
                    int A = 1;    
                    int B = (randomGenerator.nextInt(3)-1);
                    int C = (randomGenerator.nextInt(3)-1);
                    int D = 0;
                    int type = (randomGenerator.nextInt(3)+1);
                    if(B%2==0){
                        int E = 0;
                        B = E;
                    }else if(B%2!=0){
                        int E = 1;
                        B = E;
                    }
                    if(C%2==0){
                        int E = 0;
                        C = E;
                    }else if(C%2!=0){
                        int E = 1;
                        C = E;
                    }
                    if(type%2==0){
                        int E = -1;
                        D = E;
                    }else if(type%2!=0){
                        int E = 1;
                        D = E;
                    }
                    PD = new PData(A,B,C,D);
                    P.input(PD);
    }
    
    // set as the question for test correct
    P_array[1].setbias(1);
    P_array[1].setx(0);
    P_array[1].sety(1);
    P_array[1].settype(-1);
    
    P_array[2].setbias(1);
    P_array[2].setx(0);
    P_array[2].sety(0);
    P_array[2].settype(-1);
    
    P_array[3].setbias(1);
    P_array[3].setx(1);
    P_array[3].sety(0);
    P_array[3].settype(-1);
   
    P_array[4].setbias(1);
    P_array[4].setx(1);
    P_array[4].sety(1);
    P_array[4].settype(1);
    
    // set weight
    /**/
    P_array[0].setx(0);
    P_array[0].sety(0);
    P_array[0].setbias(0);
    P_array[0].settype(0);
    }
    public void updateweight(){
      boolean check = true;
      for(int i = 0;check; i++){
      countround++;
      int test = randomGenerator.nextInt(4)+1;
      //System.out.println("test : "+test);
      int X = ((P_array[0].getbias()*P_array[test].getbias())+(P_array[0].getx()*P_array[test].getx())+(P_array[0].gety()*P_array[test].gety()));
      int result = X;
      int M;
      //System.out.println("result : "+result);
      if(X >= 0){
           M = 1;
      }else{
           M = -1;
      }
      //System.out.println("M : "+M+" "+" type :"+P_array[test].gettype());
        if(P_array[test].gettype() != M){
          if(P_array[test].gettype()==1){
              //positive
              int A = ((P_array[0].getbias())+(P_array[test].getbias())); 
              P_array[0].setbias(A);
              int B = ((P_array[0].getx())+(P_array[test].getx()));
              P_array[0].setx(B);
              int C = ((P_array[0].gety())+(P_array[test].gety()));   
              P_array[0].sety(C);
          }else{
              //negative
              int A = ((P_array[0].getbias())-(P_array[test].getbias())); 
              P_array[0].setbias(A);
              int B = ((P_array[0].getx())-(P_array[test].getx()));
              P_array[0].setx(B);
              int C = ((P_array[0].gety())-(P_array[test].gety()));   
              P_array[0].sety(C);
          }
        }else{
          
        }
        check = check(P_array[test].getbias(),P_array[test].getx(),P_array[test].getx());
        }
    }
    public boolean check(int bias,int x,int y){
        boolean checker = true;
        int count = 0; 
        for(int i = 1;i<=number;i++){
        int X = ((P_array[0].getbias()*P_array[i].getbias())+(P_array[0].getx()*P_array[i].getx())+(P_array[0].gety()*P_array[i].gety()));
        int result = X;
        int M;
        //System.out.println("result : "+result);
        if(X >= 0){
           M = 1;
        }else{
           M = -1;
        }
        if(P_array[i].gettype() != M){
            count--;
        }else{
            count++;  
        }
        }
        if(count==4){
            checker = false;
        }else{
            checker = true;
        }
        return checker;
    }
}
