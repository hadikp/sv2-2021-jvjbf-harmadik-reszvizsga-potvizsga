package contentsite;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContentService {

    private Set<User> allUsers = new LinkedHashSet<>();
    private Set<Content> allContent = new LinkedHashSet<>();

    public void registerUser(String name, String password) {
        if (isUsername(name)) {
            throw new IllegalArgumentException("Username is already taken: " + name);
        }
        allUsers.add(new User(name, password));

    }

    private boolean isUsername(String name) {
        return allUsers.stream().map(User::getUserName).anyMatch(u -> u.equals(name));
    }

    void addContent(Content content){
        if(!isContent(content)){
            allContent.add(content);
        } else {
            throw new IllegalArgumentException("Content name is already taken: " + content.getTitle());
        }
    }

    private boolean isContent(Content c) {
        return allContent.stream().map(Content::getTitle).anyMatch(p -> p.equals(c.getTitle()));
    }

    public void logIn(String username, String password) {
        User user = allUsers.stream().filter(l -> l.getUserName().equals(username)).findFirst().get();
        String passwordCreate = String.valueOf((username + password).hashCode());
        if (!user.getUserName().equals(username)) {
            throw new IllegalArgumentException("Username is wrong!");
        }
        if (!(String.valueOf(user.getPassword())).equals(passwordCreate)) {
            throw new IllegalArgumentException("Password is Invalid!");
        }

    }

    public void clickOnContent(User user, Content content){
        if(!content.isPremiumContent()){
            content.click(user);
        }
        if(content.isPremiumContent()){
            if(user.isLogIn()){
                content.click(user);
            } else {
                throw new IllegalArgumentException("Log in to watch this content!");
            }
        }
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public Set<Content> getAllContent() {
        return allContent;
    }
}
