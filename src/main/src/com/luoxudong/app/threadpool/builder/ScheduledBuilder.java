/**
 * Title: ScheduledBuilder.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2017年4月20日 下午3:36:55
 * Version: 1.0
 */
package com.luoxudong.app.threadpool.builder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/** 
 * <pre>
 * ClassName: ScheduledBuilder
 * Description:创建一个定长线程池，支持定时及周期性任务执行。
 * Create by: 罗旭东
 * Date: 2017年4月20日 下午3:36:55
 * </pre>
 */
public class ScheduledBuilder extends ThreadPoolBuilder<ExecutorService> {
	/** 固定线程池大小 */
	private int mSize = 1;
	
    protected ScheduledExecutorService mExecutorService = null;
    
	@Override
	protected ScheduledExecutorService create() {
		return Executors.newScheduledThreadPool(mSize);
	}
	
	@Override
	public ScheduledExecutorService builder() {
		if (mThreadPoolMap.get(mPoolName) != null) {
			mExecutorService = (ScheduledExecutorService)mThreadPoolMap.get(mPoolName);
		} else {
			mExecutorService = create();
			mThreadPoolMap.put(mPoolName, mExecutorService);
		}
		return mExecutorService;
	}
	
	public ScheduledExecutorService getExecutorService() {
		return mExecutorService;
	}
	
	public ScheduledBuilder size(int size) {
		this.mSize = size;
		return this;
	}
}
