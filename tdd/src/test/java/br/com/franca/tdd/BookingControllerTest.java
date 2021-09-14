package br.com.franca.tdd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.franca.tdd.controller.BookingController;
import br.com.franca.tdd.model.BookingModel;

// @SpringBootTest
// @AutoConfigureMockMvc
@RunWith(SpringRunner.class) // ?
@WebMvcTest(BookingController.class) // ?
public class BookingControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void bookingFindAllTest() throws Exception {
		mockMvc.perform(get("/bookings")).andExpect(status().isOk());
	}
	
	@Test
	public void bookingSaveTest() throws Exception {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");

		BookingModel bookingModel = new BookingModel("1", "Rodrigo", checkIn, checkOut, 2);

		mockMvc.perform(post("/bookings")
		.contentType("application/json")
		.content(objectMapper.writeValueAsString(bookingModel)))
		.andExpect(status().isOk());

	}

}
