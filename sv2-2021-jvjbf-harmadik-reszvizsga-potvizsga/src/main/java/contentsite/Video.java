package contentsite;

import java.util.ArrayList;
import java.util.List;

public class Video implements Content {

    private int length;
    private String title;
    List<User> users = new ArrayList<>();

    public Video(String title,int length) {
        this.title = title;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean isPremiumContent() {
        if(length>15){
            return true;
        }
        return false;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<User> clickedBy() {
        return new ArrayList<>(users);
    }

    @Override
    public void click(User user) {
        users.add(user);
    }
}
