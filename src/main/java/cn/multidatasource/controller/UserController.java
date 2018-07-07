package cn.multidatasource.controller;

import cn.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author ms.liu
 * ~~Email 18310693623@163.com
 * @Date 2018-07-07 下午4:55
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/addStudent2")
    @ResponseBody
    public void addStudent2() {
        userService.list();
    }

}
