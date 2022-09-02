package com.ufuk.tickerservice.repository.elasticsearch;

import com.ufuk.tickerservice.model.elasticsearch.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel,String> {

}
