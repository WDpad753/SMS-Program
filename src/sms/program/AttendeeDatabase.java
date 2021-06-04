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

public class AttendeeDatabase 
{
    private int Attendee_ID;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String DateofBirth;
    private String PhoneNumber;
    private String Occupation;
    private String Email;
    
    public AttendeeDatabase(int Attendee_ID,String FirstName, String LastName, String Gender, String DateofBirth, String PhoneNumber, String Occupation, String Email)
    {
        this.Attendee_ID = Attendee_ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.DateofBirth = DateofBirth;
        this.PhoneNumber = PhoneNumber;
        this.Occupation = Occupation;
        this.Email = Email;
    }

    AttendeeDatabase(){}
    
    public int getAttendee_ID()
    {
        return Attendee_ID;
    }
    
    public String getFirstName()
    {
        return FirstName;
    }
    
    public String getLastName()
    {
        return LastName;
    }
    
    public String getGender()
    {
        return Gender;
    }
    
    public String getDateofBirth()
    {
        return DateofBirth;
    }
    
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }
    
    public String getOccupation()
    {
        return Occupation;
    }
    
    public String getEmail()
    {
        return Email;
    }
}