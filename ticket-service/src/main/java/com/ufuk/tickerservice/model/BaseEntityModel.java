package com.ufuk.tickerservice.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;

@MappedSuperclass // bir nesneyi diğer entitylere kazandırmak istiyorsak bu annotation kullanılır. Yani bu modeldeki bu kolonları kalıtım yoluyla her tabloya dahil etmemizi sağlar.
public abstract class BaseEntityModel implements Serializable {

  @CreatedDate
  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

}
