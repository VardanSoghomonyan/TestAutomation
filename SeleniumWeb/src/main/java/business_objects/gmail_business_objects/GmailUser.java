package business_objects.gmail_business_objects;

public class GmailUser {

    private String email;
    private String password;

    public GmailUser(String email, String password){
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public GmailUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public GmailUser setPassword(String password) {
        this.password = password;
        return this;
    }
}
