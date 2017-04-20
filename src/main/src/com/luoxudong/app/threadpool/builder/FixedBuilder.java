/**
 * Title: FixedBuilder.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2017年4月20日 下午3:36:36
 * Version: 1.0
 */
package com.luoxudong.app.threadpool.builder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * <pre>
 * ClassName: FixedBuilder
 * Description:创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * Create by: 罗旭东
 * Date: 2017年4月20日 下午3:36:36
 * </pre>
 */
public class FixedBuilder extends ThreadPoolBuilder<ExecutorService> {
	/** 固定线程池  */
	private int mSize = 1;
	
	@Override
	protected ExecutorService create() {
		return Executors.newFixedThreadPool(mSize);
	}

	public FixedBuilder setSize(int size) {
		mSize = size;
		return this;
	}
}
