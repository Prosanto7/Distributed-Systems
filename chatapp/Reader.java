/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

/**
 *
 * @author User
 */
public class Reader implements Runnable{
    public NetworkConnection netConnection;
    String msg="";
    public static boolean check = false;
    public Reader(NetworkConnection nc){
        netConnection=nc;
    }
    public void setMessage(String msg){
        this.msg=msg;
    }
    public void StartThread(){
        new Thread(this).start();
        //this.start();
    }
    public String getMessage() {
        if(msg!=null)
        return msg;
        else return "";
    }
    
    
    @Override
    public void run() {
        while(true){
            String msg;
            Object obj=netConnection.read();
            msg = (String) obj;
            //Data dataObj=(Data)obj;
            if(!getMessage().equals(msg));
            {
                setMessage(msg);
                System.out.println("Received : "+msg);
                check = false;
            }
//            if(check==true){
//            setMessage(msg);
//            System.out.println("Received : "+msg);
//            check = false;
//            }
            
        }
    }
    
}
