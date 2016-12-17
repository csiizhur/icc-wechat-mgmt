package com.iccspace.icc_wechat_mgmt.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
/**
 * 实现对象的序列化接口
 * @description
 * @author zhur
 * @date 2016年12月8日-下午1:25:21
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

  private Converter<Object, byte[]> serializer = new SerializingConverter();
  private Converter<byte[], Object> deserializer = new DeserializingConverter();

  static final byte[] EMPTY_ARRAY = new byte[0];

  public Object deserialize(byte[] bytes) {
    if (isEmpty(bytes)) {
      return null;
    }

    try {
      return deserializer.convert(bytes);
    } catch (Exception ex) {
      throw new SerializationException("Cannot deserialize", ex);
    }
  }

  public byte[] serialize(Object object) {
    if (object == null) {
      return EMPTY_ARRAY;
    }

    try {
      return serializer.convert(object);
    } catch (Exception ex) {
      return EMPTY_ARRAY;
    }
  }

  private boolean isEmpty(byte[] data) {
    return (data == null || data.length == 0);
  }
}