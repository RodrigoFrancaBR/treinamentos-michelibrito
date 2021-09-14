package br.com.franca.tdd.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.franca.tdd.model.BookingModel;
import br.com.franca.tdd.service.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public int daysCalculatorWithDatabase(String name) {
		Optional<BookingModel> bookingModelOptional = this.bookingRepository.findByReserveName(name);
		return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut())
				.getDays();
	}

}
