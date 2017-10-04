package cad.osb.birthdaycountdown.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.io.Serializable;
import java.util.Date;

public class BirthdayDTO implements Serializable{

    private Date date;

    public BirthdayDTO() {
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
