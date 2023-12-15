package vttp.ssf.assessment.eventmanagement.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserReg {

    
    @NotEmpty(message = "Name is a required field")
    @Size(min=5, max=25)
    private String fullName;

    @DateTimeFormat(pattern = "DD-MM-YYYY")
    @Past(message = "Please enter a valid birthday.")
    private Date birthday;

    @NotBlank(message = "Email is a required field")
    @Email
    @Size(max = 50)
    private String email;

    @Digits(fraction = 0, integer = 8)
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Invalid phone number entered")
    private String mobileNum;

    @Min(1)
    @Max(3)
    private Integer ticketsReq;

    private String gender;


    private String event;

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobileNum() {
        return mobileNum;
    }
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }
    public Integer getTicketsReq() {
        return ticketsReq;
    }
    public void setTicketsReq(Integer ticketsReq) {
        this.ticketsReq = ticketsReq;
    }
    
}
