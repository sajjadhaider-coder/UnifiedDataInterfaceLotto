package com.data.UnifiedLottoDataInterface;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
public class UnifiedDataInterfaceLottoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnifiedDataInterfaceLottoApplication.class, args);
	}
}
