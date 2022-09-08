package com.kingsley.logging.boot.autoconfigure.trace;

import com.kingsley.logging.boot.autoconfigure.util.SpringContextUtil;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 * @author kingsley
 * @time 2022/5/19 11:04
 * @ide IntelliJ IDEA
 * @name com.kingsley.music.aspect.context.LogContext
 * @desc 日志上下文
 */
public final class LogContext {

    public static final String TRACE_ID = "traceId";
    /**
     * 调用链执行次数，每进入一次方法，执行次数加1，执行完方法次数减1
     */
    private static final ThreadLocal<Integer> chainCount = ThreadLocal.withInitial(() -> 0);
    private static final TraceIdGenerateStrategy generateStrategy;

    static {
        generateStrategy = SpringContextUtil.getBean(TraceIdGenerateStrategy.class);
    }

    public static int getCount() {
        return chainCount.get();
    }

    /**
     * 日志上下文放置参数
     */
    public static void putTraceId() {
        String traceId = MDC.get(TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            MDC.put(TRACE_ID, generateStrategy.generateTraceId());
        }
        chainCount.set(chainCount.get() + 1);
    }

    /**
     * 日志上下文清除或更新参数
     */
    public static void clearTraceId() {
        Integer currentCount = chainCount.get();
        if (currentCount == 1) {
            // log.info("清空线程 {} 的调用链统计】和【日志上下文】", Thread.currentThread().getName());
            // 清空调用链统计
            chainCount.remove();
            // 清空日志上下文
            MDC.clear();
        }
        chainCount.set(currentCount - 1);
    }

}