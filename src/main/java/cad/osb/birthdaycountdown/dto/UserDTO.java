package cad.osb.birthdaycountdown.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDTO {

    private int id;
    private String name;
    private String birthDay;

    public UserDTO() {
    }

    public UserDTO(String name, String birthDay) {
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
