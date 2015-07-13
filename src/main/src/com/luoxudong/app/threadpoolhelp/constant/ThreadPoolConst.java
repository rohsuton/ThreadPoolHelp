/**
 * Title: ThreadPoolConst.java
 * Description: 
 * Copyright: Copyright (c) 2013-2015 luoxudong.com
 * Company: 个人
 * Author: 罗旭东 (hi@luoxudong.com)
 * Date: 2015年7月13日 上午10:37:47
 * Version: 1.0
 */
package com.luoxudong.app.threadpoolhelp.constant;

/** 
 * ClassName: ThreadPoolConst
 * Description:TODO(这里用一句话描述这个类的作用)
 * Create by: 罗旭东
 * Date: 2015年7月13日 上午10:37:47
 */
public class ThreadPoolConst {
	/**
	 * 普通工作线程池
	 */
	public static final int THREAD_TYPE_WORK = 0;
	
	/**
	 * 接口请求线程池
	 */
	public static final int THREAD_TYPE_SIMPLE_HTTP = 1;
	
	/**
	 * 文件传输线程池
	 */
	public static final int THREAD_TYPE_FILE_HTTP = 2;
	
	/**
	 * 其他线程池
	 */
	public static final int THREAD_TYPE_OTHERS = 3;
	
	/**
	 * 空闲线程存活时间,5秒
	 */
	public static final long KEEP_ALIVE_TIME = 5000;

	/**
	 * 有界队列长度
	 */
	public final static int DEFAULT_WORK_QUEUE_SIZE = 10;
}
