package com.beannote.beannote.user.dao;

import com.beannote.beannote.common.User;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select count(*) from t_user where username = #{username}")
    int selectByUsername(@Param("username") String username);

    @Select("select password from t_user where username = #{username}")
    String getPassword(String username);

    @SelectKey(keyProperty = "uid", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert("INSERT INTO t_user (uid,username,password) VALUES(#{uid},#{username}, #{password})")
    int insertUser(User user) throws MySQLIntegrityConstraintViolationException;
}
