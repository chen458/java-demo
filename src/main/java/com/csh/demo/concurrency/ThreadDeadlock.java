package com.csh.demo.concurrency;


import java.util.concurrent.*;

/**
 * 线程饥饿死锁:
 *  单线程的 Executors 中,一个任务执行依赖于同一 Executors 中另一任务
 *
 * @author: shenghong.chen
 * Date: 2017/7/9
 * time: 上午12:30
 */
public class ThreadDeadlock {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> page = executorService.submit(new LoadPageTask(executorService));
        System.out.println("页面内容 : " + page.get());

    }

    /**
     * 页面整体加载
     */
    static class LoadPageTask implements Callable<String> {
        private ExecutorService executorService;

        public LoadPageTask(ExecutorService executorService) {
            this.executorService = executorService;
        }

        @Override
        public String call() throws Exception {
            Future<String> header = executorService.submit(new LoadFileTask("html 页眉文件"));
            Future<String> footer = executorService.submit(new LoadFileTask("html 页脚文件"));
            return header.get() + " ====== " + footer.get();
        }
    }

    /**
     * 部分加载
     */
    static class LoadFileTask implements Callable<String> {
        private String fileName;

        public LoadFileTask(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public String call() throws Exception {
            return fileName;
        }
    }

}
