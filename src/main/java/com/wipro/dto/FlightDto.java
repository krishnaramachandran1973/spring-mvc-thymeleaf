package com.wipro.dto;

import java.time.LocalDateTime;

import com.wipro.model.FlightType;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightDto {
	private Long id;
	@NotNull
	private String flightNumber;
	@NotNull
	private String departureAirport;
	@NotNull
	private String destinationAirport;
	@NotNull
	private LocalDateTime departureTime;
	@NotNull
	private LocalDateTime arrivalTime;
	@NotNull
	private int availableSeats;
	@Default
	private FareDto fareDto = new FareDto();
	@NotNull
	private FlightType type;
}
