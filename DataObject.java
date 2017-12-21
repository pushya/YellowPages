import java.io.*;
import java.util.*;

public class DataObject implements Serializable{
    
    protected String Message;
    
    DataObject(){
        Message = "";
    }
    
    public String getMessage(){
        return Message;
    }
    
    public void setMessage(String inMessage){
        Message = inMessage;
    }
}
