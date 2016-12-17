package com.iccspace.icc_wechat_mgmt.jpa;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TUserServiceImpl implements TUserService {

	@Resource
	private TUserRepository userRepository;

	@Resource
	private RedisTemplate<String, String> redisTemplate;

	/*@Override
	public void test() {
		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("mykey4", "random1=" + Math.random());
		System.out.println(valueOperations.get("mykey4"));
	}*/

	// keyGenerator="myKeyGenerator"
	/*@Cacheable(value = "demoInfo") // 缓存,这里没有指定key.
	@Override
	public DemoInfo findById(long id) {
		System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
		return demoInfoRepository.findOne(id);
	}*/

	/*@CacheEvict(value = "demoInfo")
	@Override
	public void deleteFromCache(long id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
	}*/

	@Override
	@CachePut(value="user",key="#user.id")
	public TUser save(TUser user) {
		TUser u=userRepository.save(user);
		System.err.println("缓存key="+u.getId());
		return null;
	}

	@Override
	@CacheEvict(value="user")
	public void remove(long id) {
		System.err.println("删除缓存key="+id);
		
	}

	@Override
	@Cacheable(value="user",key="#user.id")
	public TUser findOne(TUser user) {
		TUser u=userRepository.findOne(user.getId());
		System.err.println("缓存key="+u.getId());
		return null;
	}

}
