package cn.multidatasource.dao;

import cn.multidatasource.pojo.Topic;
import cn.multidatasource.pojo.User;

import java.util.List;

/**
 * @Author ms.liu
 * ~~Email 18310693623@163.com
 * @Date 2018-07-07 下午4:51
 */
public interface UserMapper {


    void insert(User tAllusers2);

    List<Topic> selectTopicList();
}
