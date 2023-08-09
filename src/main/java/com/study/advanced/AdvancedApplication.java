package com.study.advanced;

import com.study.advanced.proxy.config.v1_proxy.InterfaceProxyConfig;
import com.study.advanced.trace.logtrace.LogTrace;
import com.study.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(AppV1Config.class)
//@Import({AppV1Config.class, AppV2Config.class})
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "com.study.advanced.proxy.app")
public class AdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedApplication.class, args);
	}

	@Bean
	LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}
}
