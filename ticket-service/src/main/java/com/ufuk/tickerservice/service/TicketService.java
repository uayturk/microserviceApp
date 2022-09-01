package com.ufuk.tickerservice.service;

import com.ufuk.tickerservice.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

  TicketDto save(TicketDto ticketDto);

  TicketDto update(String id, TicketDto ticketDto);

  TicketDto getById(String ticketId);

  Page<TicketDto> getPagination(Pageable pageable);
}
