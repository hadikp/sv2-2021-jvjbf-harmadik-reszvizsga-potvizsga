package contentsite;

import java.util.LinkedHashSet;
import java.util.Set;

public class ContentService {

    private Set<User> allUsers = new LinkedHashSet<>();
    private Set<Content> allContent = new LinkedHashSet<>();

    public void registerUser(String name, String password) {
        if (isUsername(name)) {
            throw new IllegalArgumentException("Username is already taken:" + name);
        }
        allUsers.add(new User(name, password));

    }

    private boolean isUsername(String name) {
        return allUsers.stream().map(User::getUserName).anyMatch(u -> u.equals(name));
    }

    void addContent(Content content){
        if(!allContent.contains(content.getTitle())){
            allContent.add(content);
        }
    }

    public void logIn(String username, String password) {
        User user = allUsers.stream().filter(l -> l.getUserName().equals(username)).findFirst().get();
        String passwordCreate = String.valueOf((username + password).hashCode());
        if (user.isLogIn())
    }

    public Set<User> getAllUsers() {
        return allUsers;
    }

    public Set<Content> getAllContent() {
        return allContent;
    }
}
