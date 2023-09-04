package com.study.advanced.proxy.config.v6_aop;

import com.study.advanced.proxy.config.AppV1Config;
import com.study.advanced.proxy.config.AppV2Config;
import com.study.advanced.proxy.config.v6_aop.aspect.LogTraceAspect;
import com.study.advanced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class AopConfig {

    @Bean
    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
        return new LogTraceAspect(logTrace);
    }
}
