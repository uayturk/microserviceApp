package com.ufuk.accountservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ModelMapper, javada property name'lerine bakarak, hangi propertynin ne ile örtüşeceğini otomatik algılıyor. Kısaca property name'lerin eşleşmelerini tarıyor
@Configuration // @Configuration ile yani spring ayağa kalkarken bunu initialize etsin diyoruz.
public class CustomBeanFactory {

  @Bean
  public ModelMapper getModelMapper(){
    return new ModelMapper();
  }

}
