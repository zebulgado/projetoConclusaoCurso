package br.com.qualiti.projetoConclusaoCurso.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualiti.projetoConclusaoCurso.model.Hotel;
import br.com.qualiti.projetoConclusaoCurso.model.Prices;
import br.com.qualiti.projetoConclusaoCurso.service.PricesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
public class PricesController {
	
	private PricesService pricesService;

	public PricesController(PricesService pricesService) {
		super();
		this.pricesService = pricesService;
	}
	
	@ApiOperation(value = "Get all prices")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK")
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Prices>> getPricesAll(
			@RequestParam(name = "name", required = false) String name) {
		List<Prices> pricesList = pricesService.findAll();
		return new ResponseEntity<>(pricesList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{cnpj}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Prices> getPrices(@PathVariable(value = "cnpj") String cnpj) {
		Prices prices = pricesService.findById(cnpj);
		if (prices == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(prices, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Create prices")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 400, message = "Bad Request")
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Prices> createPrices(@RequestBody Prices prices) {
		prices = pricesService.save(prices);
		if (prices == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(prices, HttpStatus.CREATED);
		}
	}
	
	@ApiOperation(value = "Update prices")
	@ApiResponses({
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found")
	})
	@PutMapping(value = "/{cnpj}", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Prices> updatePrices(@PathVariable(value = "cnpj") String cnpj,
			@RequestBody Prices prices) {
		prices = pricesService.update(prices);
		if (prices == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(prices, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Delete prices")
	@ApiResponses({
		@ApiResponse(code = 204, message = "No Content"),
		@ApiResponse(code = 400, message = "Bad Request")
	})
	@DeleteMapping(value = "/{cnpj}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deletePrices(@PathVariable(value = "cnpj") String cnpj) {
		pricesService.deleteById(cnpj);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Delete all prices")
	@ApiResponses({
		@ApiResponse(code = 204, message = "No Content")
	})
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteHotels() {
		pricesService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
