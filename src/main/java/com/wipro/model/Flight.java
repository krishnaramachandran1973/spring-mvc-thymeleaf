package com.wipro.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@NamedEntityGraph(name = "Flight.fare", attributeNodes = @NamedAttributeNode("fare"))
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "flightNumber")
	private String flightNumber;
	@Column(name = "departureAirport")
	private String departureAirport;
	@Column(name = "destinationAirport")
	private String destinationAirport;
	@Column(name = "departureTime")
	private LocalDateTime departureTime;
	@Column(name = "arrivalTime")
	private LocalDateTime arrivalTime;
	@Column(name = "availableSeats")
	private int availableSeats;
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "fare_id")
	private Fare fare;
	@Enumerated(EnumType.STRING)
	private FlightType type;

}
