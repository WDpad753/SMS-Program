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
public class EmployeeDatabase {
    private int Emp_ID;
    private String Email;
    private String Password;
    private String Firstname;
    private String Lastname;
    private String Gender;
    private String DateofBirth;
    private String Occupation;
    private String Phonenumber;
    
    public EmployeeDatabase(int Emp_ID, String Email, String Password, String Firstname, String Lastname, String Gender, String DateofBirth, String Occupation, String Phonenumber)
    {
        this.Emp_ID = Emp_ID;
        this.Email= Email;
        this.Password = Password;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Gender = Gender;
        this.DateofBirth = DateofBirth;
        this.Occupation = Occupation;
        this.Phonenumber = Phonenumber;

    }

    EmployeeDatabase(){}
    
    public int getEmp_ID()
    {
        return Emp_ID;
    }
    
    public String getEmail()
    {
        return Email;
    }
    
    public String getPassword()
    {
        return Password;
    }
    
    public String getFirstname()
    {
        return Firstname;
    }
    
    public String getLastname()
    {
        return Lastname;
    }
    
    public String getGender()
    {
        return Gender;
    }
    
    public String getDateofBirth()
    {
        return DateofBirth;
    }
    
    public String getOccupation()
    {
        return Occupation;
    }
    
    public String getPhonenumber()
    {
        return Phonenumber;
    }
}