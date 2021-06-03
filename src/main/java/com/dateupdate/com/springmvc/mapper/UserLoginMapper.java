package com.dateupdate.com.springmvc.mapper;

import com.dateupdate.com.springmvc.model.UserLoginUP;
import org.apache.ibatis.annotations.Mapper;

import java.lang.annotation.Documented;

/**
 * @author 李浩然
 */
@Mapper
public interface UserLoginMapper {

    UserLoginUP selectPassword(String id);
}
