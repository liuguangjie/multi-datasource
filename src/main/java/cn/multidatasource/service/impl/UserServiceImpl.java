package cn.multidatasource.service.impl;

import cn.multidatasource.dao.UserMapper;
import cn.multidatasource.dynamic.DataSource;
import cn.multidatasource.pojo.Student;
import cn.multidatasource.pojo.Topic;
import cn.multidatasource.pojo.User;
import cn.multidatasource.service.UserService;
import cn.multidatasource.stu.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ms.liu
 * ~~Email 18310693623@163.com
 * @Date 2018-07-07 下午4:54
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private StudentMapper studentMapper;


    @Autowired(required = false)
    private UserMapper userMapper;

    public void addStudent2() {
        //TAllusers tAllusers1 = tAllusersMapper.selectByPrimaryKey(1);
        //System.out.println(tAllusers1);

        Student tStudent = new Student();
        tStudent.setAddress("langfang");
        tStudent.setName("AresCCCC" + System.currentTimeMillis());
        studentMapper.insert(tStudent);

        User tAllusers2 =new User();
        tAllusers2.setAddress("shagnhai");
        tAllusers2.setName("AresDDDD" + System.currentTimeMillis());
        userMapper.insert(tAllusers2);
        int i = 1/0;
    }

    /**
     * 指定数据源
     */
    @DataSource("slave")
    public void list() {

        List<Topic> topicList = userMapper.selectTopicList();

        System.out.println(topicList);
    }
}
