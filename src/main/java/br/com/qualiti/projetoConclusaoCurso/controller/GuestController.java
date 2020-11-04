package br.com.qualiti.projetoConclusaoCurso.controller;

import java.security.NoSuchAlgorithmException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualiti.projetoConclusaoCurso.model.Guest;
import br.com.qualiti.projetoConclusaoCurso.service.GuestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

	@RestController
	@RequestMapping(path = "/guest", produces = MediaType.APPLICATION_JSON_VALUE)
	public class GuestController {
		
		private GuestService guestService;

		public GuestController(GuestService guestService) {
			super();
			this.guestService = guestService;
		}
		
		@ApiOperation(value = "Get all Guests")
		@ApiResponses({
			@ApiResponse(code = 200, message = "OK")
		})
		@GetMapping
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<List<Guest>> getGuestList() {
			List<Guest> holtels = guestService.findAll();
			return new ResponseEntity<>(holtels, HttpStatus.OK);
		}
		
		@ApiOperation(value = "Get guest")
		@ApiResponses({
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found")
		})
		@GetMapping(value = "/{cpf}")
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Guest> getGuest(@PathVariable(value = "cpf") String cpf) {
			Guest guest = guestService.findById(cpf);
			if (guest == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(guest, HttpStatus.OK);
			}
		}
		
		@ApiOperation(value = "Create guest")
		@ApiResponses({
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request")
		})
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) throws NoSuchAlgorithmException {
			guest = guestService.save(guest);
			if (guest == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<>(guest, HttpStatus.CREATED);
			}
		}
		
		@ApiOperation(value = "Update guest")
		@ApiResponses({
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found")
		})
		@PutMapping(value = "/{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<Guest> updateGuest(@PathVariable(value = "cpf") String cpf,
				@RequestBody Guest guest) throws NoSuchAlgorithmException {
			guest = guestService.update(guest);
			if (guest == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(guest, HttpStatus.OK);
			}
		}

		@ApiOperation(value = "Delete guest")
		@ApiResponses({
			@ApiResponse(code = 204, message = "No Content"),
			@ApiResponse(code = 400, message = "Bad Request")
		})
		@DeleteMapping(value = "/{cpf}")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public ResponseEntity<Void> deleteGuest(@PathVariable(value = "cpf") String cpf) {
			guestService.deleteById(cpf);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		@ApiOperation(value = "Delete all guests")
		@ApiResponses({
			@ApiResponse(code = 204, message = "No Content")
		})
		@DeleteMapping
		@ResponseStatus(HttpStatus.NO_CONTENT)
		public ResponseEntity<Void> deleteGuests() {
			guestService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

}
