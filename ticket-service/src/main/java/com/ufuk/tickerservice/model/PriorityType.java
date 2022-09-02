package com.ufuk.tickerservice.model;

import lombok.Getter;

@Getter
public enum PriorityType {
  URGENT("urgent"),
  LOW("low"),
  HIGH("high");

  private  String label; // kullanıcı combobox'ta label'ını görsün diye bunu koyduk. yani URGENT,LOW,HIGH görmesin. bunlar veritabanında ise 0,1,2 olarak görünecek.

  PriorityType(String label){
    this.label = label;
  }
}
