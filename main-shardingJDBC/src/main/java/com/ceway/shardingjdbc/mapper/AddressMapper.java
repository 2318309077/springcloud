package com.ceway.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceway.shardingjdbc.bo.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/8 2:58 下午
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    /**
     * 保存
     */
    void save(Address address);

    /**
     * 查询
     * @param id
     * @return
     */
    Address get(Long id);
}
