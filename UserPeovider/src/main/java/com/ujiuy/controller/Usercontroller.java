package com.ujiuy.controller;

import com.ujiuy.po.User;
import com.ujiuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Usercontroller {
    @Autowired
    UserService userService;
    @GetMapping("/")

    public Map findAll(){
        Map map=new HashMap();
        List<User> list = userService.finAll();
        map.put("list",list);
        map.put("version","UserProvider01");
       /* int sleep = new Random().nextInt(1000);
        System.out.println("服务1，休息:"+sleep);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return map;
    }
  @GetMapping("/toEdit/{id}")
    public User findOne(Model m,@PathVariable Long id){
      return  userService.findOne(id);


  }
  @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "dsuccess";
  }
  @PutMapping("/update")
    public String update(@RequestBody  User user){
        userService.update(user);
        return "updatsuccess";
  }
  @GetMapping("toAdd")
    public String toadd(){

        return "useradd";
    }

  @PostMapping("/add")
    public String add(@RequestBody User user){
        userService.add(user);
        return "success";
  }


}
