package com.qiandao.delayqueue;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/18 10:27
 */
public class TaskManager {
}
/*
public class TaskManager implements ApplicationContextAware,
		InitializingBean,DisposableBean{
	private static final DelayQueue<TaskMessage>  queue = new DelayQueue<>();
	private static final TaskDelayManage taskDelayManageThread = new TaskDelayManage();

	@Override
	public void afterPropertiesSet() throws Exception {
		for (int i = 0; i < threadCount; i++) {
			TaskConsumer taskConsumer = new TaskConsumer(queue, i);
			taskConsumerList.add(taskConsumer);
			Thread thread = new Thread(taskConsumer);
			threadList.add(thread);
			thread.start();
		}
	}

	@Override
	public void destroy() throws Exception {
		for(int i=0;i<threadList.size();i++){
			threadList.get(i).interrupt();
			taskConsumerList.get(i).setSignal(Boolean.FALSE);
		}
	}
}
*/
