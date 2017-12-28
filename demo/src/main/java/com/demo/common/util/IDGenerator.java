package com.demo.common.util;

import java.util.UUID;

/**
 * <p>[描述信息：ID生成工具]</p>
 *
 * @author 郑成杰 
 * @mail zhengchj@neusoft.com
 * @version 1.0 Created on 2017-7-4 下午02:42:04
 */
public class IDGenerator {
	public static String generateId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String generateId(String sequenceName) {
		return generateId();
	}
}
