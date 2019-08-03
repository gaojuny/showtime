package com.gaojun.showtime;

import com.gaojun.showtime.mapper.ConsumerMapper;
import com.gaojun.showtime.model.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowtimeApplicationTests {
    @Resource
    private ConsumerMapper consumerMapper;
    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    @Test
    public void contextLoads() {
        List<Consumer> allUser = consumerMapper.getAllUser();

        System.out.println(allUser);
    }

    @Test
    public void redisTest(){
        Consumer consumer = new Consumer();
        Boolean hasUserId = redisTemplate.hasKey("userId");
        ValueOperations<String, Long> stringLongValueOperations = redisTemplate.opsForValue();
        if (hasUserId == null || !hasUserId){
            stringLongValueOperations.set("userId", 1L);
            redisTemplate.persist("userId");
        }
        Long newUserId = stringLongValueOperations.increment("userId");
        consumer.setId(newUserId);
        consumer.setName("jack");
        consumer.setAge(25);
        consumerMapper.addUser(consumer);
        List<Consumer> allUser = consumerMapper.getAllUser();
        System.out.println(allUser);
    }

}
