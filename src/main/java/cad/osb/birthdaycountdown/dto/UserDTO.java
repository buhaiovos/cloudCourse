package cad.osb.birthdaycountdown.dto;

import java.util.Date;

public class UserDTO {

    private int id;
    private String name;
    private Date birthDay;

    public UserDTO() {
    }

    public UserDTO(String name, Date birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


}
