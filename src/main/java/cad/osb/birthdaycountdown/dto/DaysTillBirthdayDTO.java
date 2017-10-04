package cad.osb.birthdaycountdown.dto;

import java.io.Serializable;

public class DaysTillBirthdayDTO implements Serializable{

    private String daysLeft;

    public DaysTillBirthdayDTO() {
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(String daysLeft) {
        this.daysLeft = daysLeft;
    }
}
