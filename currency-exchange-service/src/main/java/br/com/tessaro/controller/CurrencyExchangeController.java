package br.com.tessaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tessaro.model.CurrencyExchange;
import br.com.tessaro.service.CurrencyExchangeService;

@RestController
@RequestMapping("currency-exchange/")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService currencyService;
	
	@GetMapping("from/{from}/to/{to}")
	public ResponseEntity<CurrencyExchange> retrieveExcahngeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = currencyService.retrieveExchangeValue(from, to);
		return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
	}
	
}
