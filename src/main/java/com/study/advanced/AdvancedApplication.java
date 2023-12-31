package com.study.advanced;

import com.study.advanced.proxy.config.v6_aop.AopConfig;
import com.study.advanced.trace.logtrace.LogTrace;
import com.study.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
//@Import(DynamicProxyFilterConfig.class)
//@Import(ProxyFactoryConfigV1.class)
//@Import(ProxyFactoryConfigV2.class)
//@Import(BeanPostProcessorConfig.class)
//@Import(AutoProxyConfig.class)
//@Import(AopConfig.class)
//@SpringBootApplication(scanBasePackages = "com.study.advanced.proxy.app")
// --- 여기까지 동적 프록시와 직접 구현하는 AOP, 이후부터 스프링이 제공하는 AOP
@SpringBootApplication(scanBasePackages = "com.study.advanced.aop")
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Bean
	LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
