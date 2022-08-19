package com.ufuk.accountservice.controller;

import com.ufuk.accountservice.dto.AccountDto;
import com.ufuk.accountservice.model.Account;
import com.ufuk.accountservice.service.AccountService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor // bununla constructor injectionu kısa yolla gerçekleştirmiş olduk
public class AccountController {

  private final AccountService accountService;


  @RequestMapping(value = "/get", method = {RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<AccountDto> get(@RequestParam(required = true) String id) {
    return accountService.get(id);
  }

  @RequestMapping(value = "/save", method = {RequestMethod.POST}, produces = "application/json")
  public ResponseEntity<AccountDto> save(@RequestBody(required = true) AccountDto accountDto) {
    return accountService.save(accountDto);
  }

  @RequestMapping(value = "/update", method = {RequestMethod.PUT}, produces = "application/json")
  public ResponseEntity<AccountDto> update(@RequestParam(required = true) String id,@RequestBody(required = true) AccountDto accountDto) {
    return accountService.update(id,accountDto);
  }

  @RequestMapping(value = "/delete", method = {RequestMethod.DELETE}, produces = "application/json")
  public void delete(@RequestParam(required = true) String id) {
     accountService.delete(id);
  }


  @RequestMapping(value = "/pagination", method = {RequestMethod.POST}, produces = "application/json")
  public ResponseEntity<AccountDto> pagination() {
    return accountService.pagination();
  }

  @RequestMapping(value = "/getAll", method = {RequestMethod.GET}, produces = "application/json")
  public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable) {
    return accountService.getAll(pageable);
  }



}
