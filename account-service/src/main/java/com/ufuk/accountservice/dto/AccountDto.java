package com.ufuk.accountservice.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Dışarıyı ilgilendiren, gidip gelmesi gereken field'ları AccountDto içinde belirttik.
// Birgün gidip API'da name ve surname'i değiştirecek olursam, burdaki arayüzü ve ya işte API'ımı kullanan kişiler bundan en az etkilensin istiyoruz.
// O nedenle araya böyle bir dto nesnesi koyduk.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

  private String id;

  private String username;

  private String name;

  private String surname;

  private String email;

  private Date birthDate;

}
