package com.ufuk.accountservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(value = "accounts")
public class Account implements Serializable {

  @PrimaryKey
  private String id = UUID.randomUUID().toString();

  @Column(value ="uname")
  private String username;

  @Column(value ="name")
  private String name;

  @Column(value ="surname")
  private String surname;

  @Column(value ="email")
  private String email;

  @Column(value ="birth_date")
  private Date birthDate;

  @Column(value ="pwd")
  private String password;

  @Column(value ="created_at")
  private Date createdAt;

  @Column(value ="is_active")
  private Boolean active;

}
