package authentificationAOP;


public class SecurityManager {
    ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    public void login(String userName, String userPassword){
        threadLocal.set(new UserInfo(userName,userPassword));
    }
    public void logout(){
        threadLocal.set(null);
    }

    public UserInfo getLoggedOnUser(){
        return threadLocal.get();
    }
}
