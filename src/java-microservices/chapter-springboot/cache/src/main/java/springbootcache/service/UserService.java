/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springbootcache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import springbootcache.mapper.UserMapper;
import springbootcache.pojo.User;

@CacheConfig(cacheNames = "user")
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * @Cacheable注解将方法的运行结果进行缓存，使用相同的数据时直接从缓存中获取
     */
    @Cacheable(cacheNames = {"user"})
    public User getUserById(Integer id) {
        System.out.println("select user by id: " + id);
        User user = userMapper.getUserById(id);
        return user;
    }

    /**
     * @CachePut: 既调用方法，又更新缓存数据
     * 运行时机：
     *  1.先调用目标方法
     *  2.将目标方法的结果缓存起来
     */
    @CachePut(value = "user", key = "#result.id")
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return user;
    }

    /**
     *
     * @param id
     */
    @CacheEvict(value = "user", key = "#id")
    public void deleteUser(Integer id) {
        System.out.println("delete user: " + id);
        // userMapper.deleteUser(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(/* value = "user", */ key = "#uname")
            },
            put = {
                    @CachePut(/* value = "user",  */key = "#result.id"),
                    @CachePut(/* value = "user",  */key = "#result.email")
            }
    )
    public User getUserByUname(String uname) {
        System.out.println("select user by uname: " + uname);
        User user = userMapper.getUserByUname(uname);
        return user;
    }
}
