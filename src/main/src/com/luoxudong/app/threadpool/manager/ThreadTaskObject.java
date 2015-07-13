/**
 * Title: ThreadTaskObject.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年7月13日 上午10:42:59
 * Version: 1.0
 */
package com.luoxudong.app.threadpool.manager;

import com.luoxudong.app.threadpool.ThreadPoolFactory;
import com.luoxudong.app.threadpool.constant.ThreadPoolConst;

/** 
 * ClassName: ThreadTaskObject
 * Description:基本线程任务，未统一管理，业务中使用的线程都需要继承该类
 * Create by: 罗旭东
 * Date: 2015年7月13日 上午10:42:59
 */
public class ThreadTaskObject implements Runnable{
	
	/**
	 * 线程池类型
	 */
	protected int threadPoolType;
	
	protected String taskName = null;

	public ThreadTaskObject(int threadPoolType, String threadTaskName)
	{
		initThreadTaskObject(threadPoolType, threadTaskName);
	}
	
	public ThreadTaskObject(int threadPoolType)
	{
		initThreadTaskObject(threadPoolType, this.toString());
	}
	
	/**
	 * 在默认线程池中执行
	 */
	public ThreadTaskObject()
	{
		initThreadTaskObject(ThreadPoolConst.THREAD_TYPE_WORK, this.toString());
	}
	
	/**
	 * 初始化线程任务
	* @param threadPoolType 线程池类型
	 * @param threadTaskName 线程任务名称
	 */
	private void initThreadTaskObject(int threadPoolType, String threadTaskName)
	{
		this.threadPoolType = threadPoolType;
		String name = ThreadPoolParams.getInstance(threadPoolType).name();
		if(threadTaskName != null)
		{
			name = name + "_" + threadTaskName;
		}
		
		setTaskName(name);
	}

	/**
	 * 取得线程池类型
	 * 
	 * @return
	 */
	public int getThreadPoolType()
	{
		return threadPoolType;
	}

	/**
	 * 开始任务
	 */
	public void start()
	{
		ThreadPoolFactory.getThreadPoolManager().addTask(this);
	}
	
	
	/**
	 * 取消任务
	 */
	public void cancel()
	{
		ThreadPoolFactory.getThreadPoolManager().removeTask(this);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
}
