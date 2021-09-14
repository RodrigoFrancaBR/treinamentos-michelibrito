package br.com.franca.tdd.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.franca.tdd.model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, String> {

	Optional<BookingModel> findByReserveName(String name);

}
