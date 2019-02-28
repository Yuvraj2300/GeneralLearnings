package com.lrn.spring_elastic_search;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.lrn.spring_elastic_search.repo")
public class ESConfig {

	private String EsHost;
	private int EsPort;
	private String EsClusterName;
	
	@Bean
	public	Client	client()	throws	Exception{
		Settings	esSettings	=	Settings.builder()
				.put("cluster.name",EsClusterName)
				.build();
	  //https://www.elastic.co/guide/en/elasticsearch/guide/current/_transport_client_versus_node_client.html
        return TransportClient.builder()
        		.settings(esSettings)
        		.build()
        		.addTransportAddress(
      				  new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
	}

	@Bean
	public	ElasticsearchOperations elasticSearchTemplate() throws Exception {
		return new	ElasticsearchTemplate(client());
	}
}
