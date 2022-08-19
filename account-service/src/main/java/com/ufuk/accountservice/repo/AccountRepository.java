package com.ufuk.accountservice.repo;

import com.ufuk.accountservice.dto.AccountDto;
import com.ufuk.accountservice.model.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account,String> {

}
