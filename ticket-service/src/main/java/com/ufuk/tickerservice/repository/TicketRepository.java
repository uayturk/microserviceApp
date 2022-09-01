package com.ufuk.tickerservice.repository;

import com.ufuk.tickerservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {

}
