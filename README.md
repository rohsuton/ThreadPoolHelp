# ThreadPoolHelp

ThreadPoolHelp是一款Android平台下简单易用的线程池管理工具，包大小只有9K，能满足常用的多线程管理需求

### 简单用法

- 使用默认线程池

```java
new ThreadTaskObject() {
	@Override
	public void run() {
		//线程执行体	
	}
}.start();
```

- 指定线程池

指定线程池newPool，该线程任务将在线程池newPool中运行。

```java
new ThreadTaskObject("newPool") {
	@Override
	public void run() {
		//线程执行体	
	}
}.start();
```
以上用法能满足基本需求，如需要更加详细的配置，参考进阶用法

### 进阶用法



- 创建一个可缓存线程池

该线程池的特点是，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。

使用默认线程池
```
ThreadPoolHelp.Builder
.cached()
.builder()
.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```

使用指定线程池，poolName为线程池名称
```
ThreadPoolHelp.Builder
.cached()
.name("poolName")
.builder()
.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```

- 创建一个定长线程池

该线程池的特点是，可控制线程最大并发数，超出的线程会在队列中等待。

使用默认线程池，size为固定线程池大小
```
ExecutorService executorService = ThreadPoolHelp.Builder
								  .fixed(size)
								  .builder();
```
```
executorService.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```
使用指定线程池，poolName为线程池名称，size为固定线程大小
```
ExecutorService executorService = ThreadPoolHelp.Builder
								  .fixed(size)
								  .name("poolName")
							      .builder();
```

```
executorService.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```


- 创建一个单线程化的线程池

该线程池的特点是，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

使用 默认线程池
```
ThreadPoolHelp.Builder
.single()
.builder()
.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```

使用指定线程池，poolName为线程池名称

```
ThreadPoolHelp.Builder
.single()
.name("poolName")
.builder()
.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```

- 创建一个定长线程池定时任务

该线程池的特点是，支持定时及周期性任务执行。

```
ScheduledExecutorService executorService = ThreadPoolHelp.Builder
									       .schedule(size)
										   .scheduleBuilder();
```

```
executorService.schedule(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	}, 3000, TimeUnit.MILLISECONDS);
```

- 创建一个自定义的线程池

该线程池的特点是，如果以上都不能满足需求，开发者可以根据需求自己设置参数。

```
ExecutorService executorService = ThreadPoolHelp.Builder
								  .custom(corePoolSize, 
								          maximumPoolSize, 
										  keepAliveTime, 
										  unit, 
										  workQueue)
							 	  .builder());
```

```
executorService.execute(new Runnable() {
	@Override
	public void run() {
		//线程执行体
	});
```