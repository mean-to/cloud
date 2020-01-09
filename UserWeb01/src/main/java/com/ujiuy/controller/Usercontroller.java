package com.ujiuy.controller;

import com.ujiuy.po.User;
import com.ujiuy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class Usercontroller {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public String getList(Model m){
        Map map =userService.finAll();
        m.addAttribute("ulist",map.get("list"));
        m.addAttribute("version",map.get("list"));
        return "list";
    }
  @GetMapping("/toEdit/{id}")
    public String findOne(Model m,@PathVariable Long id){
      User user = userService.findOne(id);
      m.addAttribute("user",user);
        return "userEdit";
  }
  @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/";
  }
  @PostMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/";
  }
  @GetMapping("toAdd")
    public String toadd(){

        return "useradd";
    }

  @PostMapping("add")
    public String add(User user){
        userService.add(user);
        return "redirect:/";
  }


}
