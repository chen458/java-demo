package com.csh.demo.rxjava;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 调度器，解决Android主线程问题
 *
 * @author chenshenghong
 * @version 1.0
 * @created 2017/5/30
 * @time 下午2:59
 *
 * Schedulers.io(); //用于I/O操作（读写文件、读写数据库、网络信息交互等）;
 * Schedulers.computation(); //计算工作默认调度器,与I/O操作无关;
 * Schedulers.immediate(); //允许你立即在当前线程执行你指定的工作。它是timeout()，timeInterval()，以及timestamp()方法默认的调度器。
 * Schedulers.newThread(); //指定任务启动一个新的线程
 * Schedulers.trampoline(); //会处理它的队列并且按序运行队列中每一个任务。它是repeat()和retry()方法默认的调度器。
 */
public class RxJavaSchedulers {

    private CompositeSubscription compositeSubscription;

    public static void main(String[] args) {
        Subscription subscribe =
                Observable.just(1, 2, 3, 4, 5, 6, 7)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted runing");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext runing = " + integer);
                    }
                });


    }

    private void addSubscription(Subscription subscription){
        if (null == compositeSubscription)
            compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscription);
    }


}
