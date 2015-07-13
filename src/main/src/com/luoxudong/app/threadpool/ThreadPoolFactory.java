/**
 * Title: ThreadPoolFactory.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年7月13日 上午10:37:27
 * Version: 1.0
 */
package com.luoxudong.app.threadpool;

import com.luoxudong.app.singletonfactory.SingletonFactory;
import com.luoxudong.app.threadpool.interfaces.IThreadPoolManager;
import com.luoxudong.app.threadpool.manager.ThreadPoolManager;

/** 
 * ClassName: ThreadPoolFactory
 * Description:线程池工厂类
 * Create by: 罗旭东
 * Date: 2015年7月13日 上午10:37:27
 */
public class ThreadPoolFactory {
	public static IThreadPoolManager getThreadPoolManager()
	{
		return SingletonFactory.getInstance(ThreadPoolManager.class);
	}
}
