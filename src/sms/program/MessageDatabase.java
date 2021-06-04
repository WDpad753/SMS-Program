/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.program;

/**
 *
 * @author Admin
 */
public class MessageDatabase {
    private String FullName;
    private String PhoneNumber;
    private String Message;
    
    public MessageDatabase(String FullName, String PhoneNumber, String Message)
    {
        this.FullName = FullName;
        this.PhoneNumber = PhoneNumber;
        this.Message = Message;
    }
    
    MessageDatabase(){}
    
    public String getFullName()
    {
        return FullName;
    }
    
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }
    
    public String getMessage()
    {
        return Message;
    }
    
}
