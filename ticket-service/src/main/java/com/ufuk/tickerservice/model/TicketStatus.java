package com.ufuk.tickerservice.model;

import lombok.Getter;

@Getter
public enum TicketStatus {

  OPEN("open"),
  IN_PROGRESS("inProgress"),
  RESOLVED("resolved"),
  CLOSED("closed");

  private String label;

  TicketStatus(String label){
    this.label = label;
  }

}
