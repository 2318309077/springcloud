package com.ceway.shardingjdbc.controller;

import com.ceway.shardingjdbc.bo.Address;
import com.ceway.shardingjdbc.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/8 3:07 下午
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
            //(required = false)
    private AddressMapper addressMapper;

    @RequestMapping("/address/save")
    @ResponseBody
    public String save() {
        for (int i = 0; i <10 ; i++) {
            Address address=new Address();
            address.setCode("code_"+i);
            address.setName("name_"+i);
            address.setPid(i+"");
            address.setType(0);
            address.setLit(i%2==0?1:2);
            addressMapper.save(address);
        }

        return "success";
    }

    @RequestMapping("/address/get/{id}")
    @ResponseBody
    public Address get(@PathVariable Long id) {
        return addressMapper.get(id);
    }
}

