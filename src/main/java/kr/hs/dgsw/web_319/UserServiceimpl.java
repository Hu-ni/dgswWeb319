package kr.hs.dgsw.web_319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceimpl implements  UserService {

    List<User> userList;

    public UserServiceimpl(){
        userList = new ArrayList<User>();
        userList.add(new User("user1","user1@dgsw.hs.kr"));
        userList.add(new User("user2","user2@dgsw.hs.kr"));
        userList.add(new User("user3","user3@dgsw.hs.kr"));
    }

    @Override
    public List<User> list() {
        return userList;
    }

    @Override
    public User view(String name){
        User found = this.userList.stream().
                filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

    @Override
    public boolean add(User user){
        return this.userList.add(user);
    }

    @Override
    public User update(User user){
        User found = this.view(user.getName());
        if(found != null)
            found.setEmail(user.getEmail());
        return found;
    }

    @Override
    public boolean delete(String name) {
        User found = this.view(name);
        return this.userList.remove(found);
    }

    public User find1(String name){
        Iterator<User> iterator = this.userList.iterator();
        while(iterator.hasNext()){
            User found = iterator.next();
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }
    public User find2(String name){
        for(User found: this.userList){
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }
    public User find3(String name){
        for(int i = 0; i< userList.size(); i++){
            User found = this.userList.get(i);
            if(found.getName().equals(name))
                return found;
        }
        return null;
    }
}
