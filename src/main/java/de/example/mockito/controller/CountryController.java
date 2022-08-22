package de.example.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.example.mockito.dto.CountryDto;
import de.example.mockito.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;

	@GetMapping("/countries")
	public ResponseEntity<List<CountryDto>> getCountries() {
		String countryCodes = "col,pe,at";
		List<CountryDto> countryList = this.countryService.getAllCountries(countryCodes);
		return ResponseEntity.ok(countryList);
	}
	
}
