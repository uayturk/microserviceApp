package com.ufuk.accountservice.service.impl;


import com.ufuk.accountservice.dto.AccountDto;
import com.ufuk.accountservice.model.Account;
import com.ufuk.accountservice.repo.AccountRepository;
import com.ufuk.accountservice.service.AccountService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;
  private final ModelMapper modelMapper;

  @Override
  public ResponseEntity<AccountDto> get(String id) {
    System.out.println("ID : " + id);
    Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());//önce git veritabanından bul,bulursa datanın kendisini, değilse hatayı versin
    return ResponseEntity.ok(modelMapper.map(account,AccountDto.class)); //Veritabanından Account olarak gelen veriyi modelMapper AccountDto'ya çevirip öyle döndürecek.
  }

  @Override
  @Transactional
  public ResponseEntity<AccountDto> save(AccountDto accountDto) {
    Account account = modelMapper.map(accountDto,Account.class); //burda da aldığımız accountDto'u Account'a map ettik.
    account = accountRepository.save(account);
    accountDto.setId(account.getId());
    return ResponseEntity.ok(accountDto);
  }

  @Override
  @Transactional
  public ResponseEntity<AccountDto> update(String id,AccountDto accountDto) {
    Assert.isNull(id,"Id can not be null!"); // id null ise hata fırlatsın
    Optional<Account> account = accountRepository.findById(id);
    Account updatedAccount = account.map(
        accountItem -> {
          accountItem.setBirthDate(accountDto.getBirthDate());
          accountItem.setName(accountDto.getName());
          accountItem.setSurname(accountDto.getSurname());
          return accountItem;
    }).orElseThrow(IllegalArgumentException::new);

    return ResponseEntity.ok(modelMapper.map(accountRepository.save(updatedAccount),AccountDto.class));
  }

  @Override
  @Transactional
  public void delete(String id) {
    Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    accountRepository.delete(account);
  }

  @Override
  public ResponseEntity<AccountDto> pagination() {
    return null;
  }

  @Override
  public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable) {

    Slice<Account> accounts = accountRepository.findAll(pageable);
    modelMapper.map(accounts,AccountDto.class);
    return ResponseEntity.ok(null); // TODO under dev.
  }
}
