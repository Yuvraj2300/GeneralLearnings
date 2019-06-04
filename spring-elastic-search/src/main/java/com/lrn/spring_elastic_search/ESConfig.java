package com.lrn.spring_elastic_search;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.lrn.spring_elastic_search.repo")
public class ESConfig {

	@Value("${elasticsearch.host}")
	private String EsHost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;

	@Bean
	public Client client() {
		TransportClient client = null;
		try {
			System.out.println("host:" + EsHost + " port:" + EsPort + " clusterName: " + EsClusterName);
			client = new PreBuiltTransportClient(Settings.EMPTY)
					.addTransportAddress(new TransportAddress(InetAddress.getByName(EsHost), EsPort));
		} catch (Exception e) {
			System.out.println(e);
		}
		return client;
	}

	/*
	 * @Bean public Client client() throws Exception { Settings esSettings =
	 * Settings.builder().put("cluster.name", EsClusterName).build(); //
	 * https://www.elastic.co/guide/en/elasticsearch/guide/current/
	 * _transport_client_versus_node_client.html return
	 * TransportClient.builder().settings(esSettings).build()
	 * .addTransportAddress(new
	 * InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort)); }
	 */

	@Bean
	@Primary
	public ElasticsearchOperations elasticSearchTemplate_1() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
