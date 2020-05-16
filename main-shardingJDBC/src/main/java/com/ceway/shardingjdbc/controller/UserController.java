package com.ceway.shardingjdbc.controller;

import com.ceway.shardingjdbc.bo.User;
import com.ceway.shardingjdbc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/8 3:00 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("save")
    @ResponseBody
    public String save() {
        for (int i = 0; i <5 ; i++) {
            User user=new User();
            user.setName("test"+i);
            user.setCityId(1%2==0?1:2);
            user.setCreateTime(new Date());
            user.setSex(i%2==0?1:2);
            user.setPhone("11111111"+i);
            user.setEmail("xxxxx");
            user.setCreateTime(new Date());
            user.setPassword("eeeeeeeeeeee");
            userMapper.save(user);
        }

        return "success";
    }

    @RequestMapping("/user/get/{id}")
    @ResponseBody
    public User get(@PathVariable Long id) {
        User user =  userMapper.get(id);
        System.out.println(user.getId());
        return user;
    }

}
