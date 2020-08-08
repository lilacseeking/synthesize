package cn.lilacseeking.synthesize.gateway.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/22 04:55
 * @Description:
 */
public class CallMainTest {

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new CallableTest());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
