package de.example.mockito.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.example.mockito.dto.CountryDto;
import de.example.mockito.mapper.CountryMapper;
import de.example.mockito.restcountries.RestCountriesClient;
import de.example.mockito.restcountries.RestCountry;
import de.example.mockito.restcountries.RestCountryName;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {
	
	@Mock
	RestCountriesClient client;
	
	@Mock
	CountryMapper mapper;
	
	CountryService countryService;
	
	List<RestCountry> restCountryList;
	List<CountryDto> countryDtoList;
	
	final String COUNTRY_CODES = "pe,at";

	@BeforeEach
	void setUp() throws Exception {
		countryService = new CountryService(client, mapper);

		restCountryList = List.of(
				new RestCountry(new RestCountryName("Peru", "Republic of Peru")),
				new RestCountry(new RestCountryName("Austria", "Republic of Austria"))
				);
		
		countryDtoList = List.of(
				new CountryDto("Peru", "Republic of Peru"),
				new CountryDto("Austria", "Republic of Austria")
				);
	}


	@Test
	void getAllCountries() {
		given(client.findCountriesByCode(COUNTRY_CODES)).willReturn(restCountryList);
		given(mapper.map(restCountryList)).willReturn(countryDtoList);
		
		List<CountryDto> result = this.countryService.getAllCountries(COUNTRY_CODES);
		
		assertEquals(2, result.size());
		assertEquals("Peru", result.get(0).getCommonName());
		assertEquals("Republic of Peru", result.get(0).getOfficialName());
		assertEquals("Austria", result.get(1).getCommonName());
		assertEquals("Republic of Austria", result.get(1).getOfficialName());
	}
	
	@Test
	void getAllCountries2() {
		given(client.findCountriesByCode(COUNTRY_CODES)).willReturn(restCountryList);
		given(mapper.map(restCountryList)).willReturn(countryDtoList);
		
		List<CountryDto> result = this.countryService.getAllCountries2(COUNTRY_CODES);
		
		assertEquals(2, result.size());
		assertEquals("Peru", result.get(0).getCommonName());
		assertEquals("Republic of Peru", result.get(0).getOfficialName());
		assertEquals("Austria", result.get(1).getCommonName());
		assertEquals("Republic of Austria", result.get(1).getOfficialName());
	}

	@AfterEach
	void tearDown() throws Exception {
		reset(client, mapper);
	}

}
