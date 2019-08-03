package com.gaojun.showtime.mapper;

import com.gaojun.showtime.model.Consumer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsumerMapper {

    List<Consumer> getAllUser();
    boolean addUser(Consumer consumer);
}
