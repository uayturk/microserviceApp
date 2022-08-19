package com.ufuk.accountservice.service;

import com.ufuk.accountservice.dto.AccountDto;
import com.ufuk.accountservice.model.Account;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;

public interface AccountService {

  //private final AccountRepository accountRepository;

  ResponseEntity<AccountDto> get(String id);

  ResponseEntity<AccountDto> save(AccountDto accountDto);

  ResponseEntity<AccountDto> update(String id,AccountDto accountDto);

  void delete(String id);

  ResponseEntity<AccountDto> pagination();

  ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable);

}
