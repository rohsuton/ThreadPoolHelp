/**
 * Title: IThreadPoolManager.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年7月13日 上午10:38:28
 * Version: 1.0
 */
package com.luoxudong.app.threadpoolhelp.interfaces;

import com.luoxudong.app.threadpoolhelp.manager.BaseThreadPool;
import com.luoxudong.app.threadpoolhelp.manager.ThreadTaskObject;

/** 
 * ClassName: IThreadPoolManager
 * Description:线程池管理接口
 * Create by: 罗旭东
 * Date: 2015年7月13日 上午10:38:28
 */
public interface IThreadPoolManager {
	/**
	 * 往线程池中增加一个线程任务
	 * @param task 线程任务
	 */
	public void addTask(ThreadTaskObject task);

	/**
	 * 
	 * @description:获取指定类型的线程池，如果不存在则创建
	 * @param @param ThreadPoolType
	 * @return BaseThreadPool
	 * @throws
	 */
	public BaseThreadPool getThreadPool(int threadPoolType);
	
	/**
	 * 从线程队列中移除一个线程任务
	 * @param task 线程任务
	 * @return 是否移除成功
	 */
	public boolean removeTask(ThreadTaskObject task);
	
	/**
	 * 停止所有任务
	 */
	public void stopAllTask();
}
