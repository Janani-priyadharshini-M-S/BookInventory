
package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.State;

public interface StateRepository extends JpaRepository<State, String> {

	State getByStateCode(String code);

}
