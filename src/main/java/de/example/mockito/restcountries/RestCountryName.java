package de.example.mockito.restcountries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestCountryName {

	private String common;
	private String official;
}
