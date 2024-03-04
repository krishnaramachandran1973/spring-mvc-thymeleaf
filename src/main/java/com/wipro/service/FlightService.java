package com.wipro.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.dto.FlightDto;
import com.wipro.mapper.DataMapper;
import com.wipro.model.Flight;
import com.wipro.repository.FlightRepository;

@Transactional
@Service
public class FlightService {

	private final FlightRepository flightRepository;

	@Autowired
	public FlightService(FlightRepository flightRepository) {
		this.flightRepository = flightRepository;
	}

	public List<FlightDto> getAllFlights() {
		return flightRepository.findAll()
				.stream()
				.map(DataMapper::toFlightDto)
				.collect(toList());
	}

	public void createFlight(FlightDto flightDto) {
		Flight flight = DataMapper.toFlight(flightDto);
		this.flightRepository.save(flight);
	}

	public void deleteFlight(Long id) {
		this.flightRepository.deleteById(id);

	}
}
