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

import br.com.qualiti.projetoConclusaoCurso.model.Reservation;
import br.com.qualiti.projetoConclusaoCurso.service.ReservationService;

@RestController
@RequestMapping(path = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

	private ReservationService reservationService;

	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@ApiOperation(value = "Get all reservation")
	@ApiResponses({
	@ApiResponse(code = 200, message = "OK")
	
	})

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Reservation>> readAll(@RequestParam(name = "id") Long id) {
		List<Reservation> reservations = reservationService.findAll();
		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);

	}

	@GetMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Reservation> readById(@PathVariable(value = "id") Long id) {
		Reservation reservation = reservationService.findById(id);
		if (reservation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Create reservation")
	@ApiResponses({
	@ApiResponse(code = 201, message = "Created"),
	@ApiResponse(code = 400, message = "Bad Request"),
	@ApiResponse(code = 404, message = "Not Found")
		
	})

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
		reservation = reservationService.save(reservation);
		if (reservation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	@ApiOperation(value = "Update reservation")
	@ApiResponses({
	@ApiResponse(code = 200, message = "OK"),
	@ApiResponse(code = 400, message = "Bad Request"),
	@ApiResponse(code = 404, message = "Not Found")
	
	})

	@PutMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Reservation> update(@RequestBody Reservation reservation , @PathVariable(value = "id") Long id) {

		reservation.setId(id);
		reservation = reservationService.update(reservation);

		if (reservation == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(HttpStatus.CREATED);

		}
	}
	
	@ApiOperation(value = "Delete reservation")
	@ApiResponses({
	@ApiResponse(code = 204, message = "No Content"),
	@ApiResponse(code = 400, message = "Bad Request"),
	@ApiResponse(code = 404, message = "Not Found")
	
	})

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
		reservationService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		reservationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
