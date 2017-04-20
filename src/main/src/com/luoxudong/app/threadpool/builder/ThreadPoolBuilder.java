/**
 * Title: ThreadPoolBuilder.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2017年4月20日 下午3:40:45
 * Version: 1.0
 */
package com.luoxudong.app.threadpool.builder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/** 
 * <pre>
 * ClassName: ThreadPoolBuilder
 * Description:TODO(这里用一句话描述这个类的作用)
 * Create by: 罗旭东
 * Date: 2017年4月20日 下午3:40:45
 * </pre>
 */
public abstract class ThreadPoolBuilder<T extends ExecutorService> {
	protected Map<String, ExecutorService> mThreadPoolMap = new ConcurrentHashMap<String, ExecutorService>();
	protected ExecutorService mExecutorService = null;
	
	protected String mPoolName = "default";
	
	protected abstract T create();

	public ExecutorService builder() {
		if (mThreadPoolMap.get(mPoolName) != null) {
			mExecutorService = mThreadPoolMap.get(mPoolName);
		} else {
			mExecutorService = create();
			mThreadPoolMap.put(mPoolName, mExecutorService);
		}
		return mExecutorService;
	}
	
	public ThreadPoolBuilder<T> poolName(String poolName) {
		mPoolName = poolName;
		return this;
	}
}
