/**
 * Title: CachedBuilder.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2017年4月20日 下午3:35:50
 * Version: 1.0
 */
package com.luoxudong.app.threadpool.builder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * <pre>
 * ClassName: CachedBuilder
 * Description:创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
			        线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 * Create by: 罗旭东
 * Date: 2017年4月20日 下午3:35:50
 * </pre>
 */
public class CachedBuilder extends ThreadPoolBuilder<ExecutorService> {
	@Override
	protected ExecutorService create() {
		return Executors.newCachedThreadPool();
	}
}
