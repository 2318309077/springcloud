package com.ceway.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceway.shardingjdbc.bo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/8 2:58 下午
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 保存
     */
    void save(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    User get(Long id);
}
