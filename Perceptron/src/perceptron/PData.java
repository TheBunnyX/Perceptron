/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author Mongkol
 */
public class PData {
    private int x;
    private int y;
    private int bias;
    private int type; 
    
    public PData(int type){
    this.type = type;
    }
    public PData(int bias,int x,int y){
    this.x = x ;
    this.y = y;
    this.bias  = bias;
    }
    public PData(int bias,int x,int y,int type){
    this.x = x ;
    this.y = y;
    this.bias  = bias;
    this.type = type;
    }
    public void setx(int x){
        this.x = x;
    }
    public void sety(int y){
        this.y = y;
    }
    public void setbias(int value){
        this.bias = value ;
    }
    public void settype(int type){
        this.type = type ;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getbias(){
        return bias;
    }
    public int gettype(){
        return type;
    }
}
