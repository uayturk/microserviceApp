package com.ufuk.tickerservice.controller;

import com.ufuk.tickerservice.dto.TicketDto;
import com.ufuk.tickerservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

  private final TicketService ticketService;


  @RequestMapping(value = "/getById/{id}", method = {RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<TicketDto> getById(@PathVariable String id) {
    return ResponseEntity.ok(ticketService.getById(id));
  }

  @RequestMapping(value = "/createTicket", method = {RequestMethod.POST}, produces = "application/json")
  public ResponseEntity<TicketDto> createTicket(@RequestBody TicketDto ticketDto) {
    return ResponseEntity.ok(ticketService.save(ticketDto));
  }

  @RequestMapping(value = "/updateTicket/{id}", method = {RequestMethod.PUT}, produces = "application/json")
  public ResponseEntity<TicketDto> updateTicket(@PathVariable String id, @RequestBody TicketDto ticketDto) {
    return ResponseEntity.ok(ticketService.update(id, ticketDto));
  }

  @RequestMapping(value = "/getAll", method = {RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<Page<TicketDto>> getAll(Pageable pageable) {
    return ResponseEntity.ok(ticketService.getPagination(pageable));
  }

}
