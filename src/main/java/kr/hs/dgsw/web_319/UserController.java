package kr.hs.dgsw.web_319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list(){
        return us.list();
    }

    @GetMapping("/user/{name}")
    @ResponseBody
    public User view(@PathVariable String name){
        return us.view(name);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user){
        return this.us.add(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user){
        return this.us.update(user);
    }

    @DeleteMapping("/user/{name}")
    public boolean delete(@PathVariable String name){
        return this.us.delete(name);
    }
}
