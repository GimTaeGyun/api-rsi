package com.bfly.management.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig {
	@Bean(name = "managementAPI")
	public WebClient webClient(WebClient.Builder builder) {
		HttpClient httpClient = HttpClient.create()
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 240000)
				.responseTimeout(Duration.ofMinutes(4))
				.doOnConnected(conn -> conn
						.addHandlerLast(new ReadTimeoutHandler(4, TimeUnit.MINUTES))
						.addHandlerLast(new WriteTimeoutHandler(4, TimeUnit.MINUTES)));

		ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)).build();

		ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

		return WebClient.builder().clientConnector(connector).exchangeStrategies(exchangeStrategies).build();
	}
}
