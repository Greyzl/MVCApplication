package authentificationAOP;

public class UserInfo {
    private String userName;
    private String userPassword;

    public UserInfo(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
