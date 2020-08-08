package cn.lilacseeking.synthesize.gateway.service;

import java.util.concurrent.Callable;

/**
 * @Auther: lilacseeking
 * @Date: 2020/5/22 04:54
 * @Description:
 */
public class CallableTest implements Callable {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        return "null";
    }
}
