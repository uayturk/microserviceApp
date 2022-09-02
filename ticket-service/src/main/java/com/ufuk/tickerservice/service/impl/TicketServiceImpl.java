package com.ufuk.tickerservice.service.impl;


import com.ufuk.tickerservice.dto.TicketDto;
import com.ufuk.tickerservice.model.PriorityType;
import com.ufuk.tickerservice.model.Ticket;
import com.ufuk.tickerservice.model.TicketStatus;
import com.ufuk.tickerservice.model.elasticsearch.TicketModel;
import com.ufuk.tickerservice.repository.TicketRepository;
import com.ufuk.tickerservice.repository.elasticsearch.TicketElasticRepository;
import com.ufuk.tickerservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * AÇIKLAMA:
 * Mesela bir 'save' işlemi yaparken, git Eureka serverdan bizim Account servislerden herhangi birini getir, tabi kaç tane oldugunu,
 * nerde olduğunu bilmiyoruz, git onlardan bir taneyi getir, o servis üzerinden git bak bakalım Ticketın üzerindeki 'assignee' kişisi,
 * yani accountu doğru mu, doğru ise git Ticket'ı oluştur, Ticket'ı oluşturduktan sonra doğru bi şekilde 'save' işlemi yaptıktan sonra,
 * git kuyruğa bir tane notification oluştur, o notification ile Account sahibine (Yani Ticket o accout sahibine atanmış ise) notif gönder
 * gibi.
 *
 * ELASTICSEARCH : Elastik tarafı için, Ticket'ın tüm detaylarını full text search içersinde bulundurcaz ve orada tüm detayları ile
 * arama yapabiliyor olcaz.
 */
@RequiredArgsConstructor //gerekli olan dependencyleri ile beraber constructer injection yaratılsın diyoruz yani bu annotationla
@Service
@Slf4j
public class TicketServiceImpl implements TicketService {

  private final TicketElasticRepository ticketElasticRepository;

  private final TicketRepository ticketRepository;

  private final ModelMapper modelMapper;

  /**
   * save metot mantığı:
   * ilk olarak Ticket model,Ticket Entity dönüşümü yap
   * sonra mysql'e kaydet,
   * TicketModel nesnesi yarat
   * sonra elastic'e kaydet
   * en son response'da oluşan nesneyi döndür
   * @param ticketDto
   * @return
   */
  @Override
  @Transactional
  public TicketDto save(TicketDto ticketDto) {

    // Ticket Entity
    if (ticketDto.getDescription() == null)
      throw new IllegalArgumentException("Description can not be empty!");

    Ticket ticket = new Ticket();
    //ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());

    ticket.setDescription(ticketDto.getDescription());
    ticket.setNotes(ticketDto.getNotes());
    ticket.setTicketDate(ticketDto.getTicketDate());
    ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
    ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
    //ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

    // mysql kaydet
    ticket = ticketRepository.save(ticket); // ticket = diyerek ticket'ı geri aldık çünkü id'si ile de onu elasticsearch'e yollıcaz


    // TicketModel nesnesi yarat
    TicketModel ticketModel = TicketModel.builder()
        .description(ticket.getDescription())
        .notes(ticket.getNotes())
        .id(ticket.getId())
        //.assignee(accountDtoResponseEntity.getBody().getNameSurname())
        .priorityType(ticket.getPriorityType().getLabel())
        .ticketStatus(ticket.getTicketStatus().getLabel())
        .ticketDate(ticket.getTicketDate()).build();

    // elastic kaydet
    ticketElasticRepository.save(ticketModel);

    // olusan nesneyi döndür
    ticketDto.setId(ticket.getId());

    // Kuyruga notification yaz
    //ticketNotificationService.sendToQueue(ticket);
    return ticketDto;

  }

  @Override
  public TicketDto update(String id, TicketDto ticketDto) {
    return null;
  }

  @Override
  public TicketDto getById(String ticketId) {
    return null;
  }

  @Override
  public Page<TicketDto> getPagination(Pageable pageable) {
    return null;
  }
}
