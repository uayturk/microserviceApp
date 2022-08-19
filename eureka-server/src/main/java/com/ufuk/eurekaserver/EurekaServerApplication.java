package com.ufuk.eurekaserver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * Elimizde çok sayıda servis, API,microservice vs olduğu zamanlar, bunların bir noktada bir katoloğa ihtiyacı vardır.
 * Yani kim hangi adrestedir,hangi IP'dedir,kaç tane instance'ı vardır bunların bilgisinin bir yerde tutulması gerekiyor.
 * Basit manada bir Registry oluşturulması gerek, servislerin,envanterlerin adresleri portları vs gibi bilgiler için.
 * Bunların hepsini biliyor olmak, mesela Account servisi bir yerde bir API isteği yapacak ve Ticket'a erişmek isticek diyelim.
 * Account Servis , Ticket'a kendisi de istek atıyor olabilir. Account Servis ayaga kalktıgında ise Ticket Servisin nerde hangi ipde ve ya portta
 * oldugunu bilmiyor olcak. İşte bunları Eureka'ya sorcak, olayı bu. Kısaca herhangi bir mikroservis başka bir mikroservis'e
 * ulaşmak istediğinde ona dair bilgileri bu katalogdan alıyor.
 */

/**
 * Neden bootstrap.yml
 * Normalde biz bir spring boot uygulamasına application.properties ve ya application.yml eklerdik.
 * Biz ise burda , bu bootstrap.yml'ı config-server'a yönlendireceğiz. Yani Eureka Server'ın tüm configuration'larını
 * config-server üzerindeki configurationlarla tutuyor olacağız. Bunun için de bu dosyanın adının bootstrap.yml olarak
 * default'ta olması gerekiyer.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerApplication.class, args);
  }

}
