package contentsite;

public class User {

    private String userName;
    private String password;
    private boolean isPremiumMember;
    private boolean isLogIn;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = String.valueOf((password.concat(userName)).hashCode());
    }

    public void upgradeForPremium() {
        setPremiumMember(true);
    }

    public void setLogIn(boolean logIn) {
        isLogIn = logIn;
    }

    public void setPremiumMember(boolean premiumMember) {
        isPremiumMember = premiumMember;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public boolean isLogIn() {
        return isLogIn;
    }
}
