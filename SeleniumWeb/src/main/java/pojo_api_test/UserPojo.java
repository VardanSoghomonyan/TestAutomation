package pojo_api_test;

import java.util.Date;

public class UserPojo {

    private int id;
    private String first_name;
    private String last_name;
    private String photo;
    private Boolean married;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public UserPojo(int id, String first_name, String last_name, String photo, Boolean married) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.photo = photo;
        this.married = married;
    }
}
