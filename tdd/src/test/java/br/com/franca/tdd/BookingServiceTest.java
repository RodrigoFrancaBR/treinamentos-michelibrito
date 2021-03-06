package br.com.franca.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.franca.tdd.model.BookingModel;
import br.com.franca.tdd.service.BookingService;
import br.com.franca.tdd.service.repository.BookingRepository;

@RunWith(SpringRunner.class) // ??
public class BookingServiceTest {

	@TestConfiguration // não sugerir no auto import em classes que não são de teste 
	static class BookingServiceTestConfiguration {

		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}

	@Autowired
	BookingService bookingService;

	@MockBean
	BookingRepository bookingRepository;

	@Test
	public void bookingServiceTestDaysCalculator() {
		String name = "Rodrigo";
		int days = bookingService.daysCalculatorWithDatabase(name);
		Assertions.assertEquals(days, 10);
	}

	@Before
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");

		BookingModel bookingModel = new BookingModel("1", "Rodrigo", checkIn, checkOut, 2);

		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
				.thenReturn(Optional.of(bookingModel));
	}
}
