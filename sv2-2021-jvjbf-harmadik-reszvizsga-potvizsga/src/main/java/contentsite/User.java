package contentsite;

public class User {

    private String userName;
    private String password;
    private boolean isPremiumMember;
    private boolean isLogIn;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = String.valueOf((userName + password).hashCode());
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

    public int getPassword() {
        return Integer.valueOf(password);
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public boolean isLogIn() {
        return isLogIn;
    }
}
