package com.kingsley.logging.boot.autoconfigure.trace;

import java.util.UUID;

/**
 * @author ZhangTao
 * @date 2022/9/4
 * @desc
 */
public class UUIDTraceIdGenerateStrategy implements TraceIdGenerateStrategy {

    @Override
    public String generateTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
