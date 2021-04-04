package com.qiandao.delayqueue;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/18 10:22
 */
public class TaskConsumer {
}
/*
public class TaskConsumer implements Runnable {

	@Override
	public void run() {
		while (signal) {
			try {
				TaskMessage take = queue.take();
				if (logger.isInfoEnabled()) {
					logger.info("处理线程的id为" + threadId + ",消息内容为：" + take.getBody() + ",预计执行时间为" +
							DateFormatUtils.timeStampToString(take.getDelay(TimeUnit.MILLISECONDS) + System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
				}
				take.getFunction().apply(take.getBody());
			} catch (InterruptedException e) {
				if (logger.isInfoEnabled()) {
					logger.info("id为" + threadId + "的处理线程被强制中断");
				}
			} catch (Exception e) {
				logger.error("taskConsumer error", e);
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("id为" + threadId + "的处理线程已停止");
		}
	}
}
*/
