/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.io.Serializable;

/**
 *
 * @author User
 */
class Data implements Serializable,Cloneable{
    public String message;           
    
    @Override
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();
    }  
}
