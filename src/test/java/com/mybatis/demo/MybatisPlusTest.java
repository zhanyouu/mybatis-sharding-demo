package com.mybatis.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.demo.mapper.UserMapper;
import com.mybatis.demo.model.User;
import com.mybatis.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@ActiveProfiles("mybatis")
@SpringBootTest
class MybatisPlusTest {
	@Autowired
	private UserMapper userMapper;
	@Test
	void contextLoads() {
		User zhangsan = User.builder().name("zhangsan").age(20).version(1).createTime(new Date()).build();
		userMapper.insert(zhangsan);
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id",1);
		userMapper.update(zhangsan,queryWrapper);
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);
	}

}
