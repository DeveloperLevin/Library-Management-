package Library;

import java.util.ArrayList;

public class Database {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> usernames = new ArrayList<String>();
    public void AddUser(User newUser) {
        users.add(newUser);
        usernames.add(newUser.getName());
    }

    public int login(String phoneNumber, String email){
        int accountExists = -1;
        for (User s : users) {
            if (s.getPhoneNumber().matches(phoneNumber) && s.getEmail().matches(email)) {
                accountExists = users.indexOf(s);
                break;
            }
        }
        return accountExists;
    }

    public User getUser(int index) {
        return users.get(index);
    }
}
