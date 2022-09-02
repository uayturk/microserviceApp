package com.ufuk.tickerservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.ufuk")
@EnableElasticsearchRepositories
@ComponentScan("com.ufuk")
public class TicketConfiguration {

  @Bean
  public ModelMapper modelMapper(){
    return new ModelMapper();
  }

}
