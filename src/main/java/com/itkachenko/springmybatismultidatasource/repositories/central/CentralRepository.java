package com.itkachenko.springmybatismultidatasource.repositories.central;

import com.itkachenko.springmybatismultidatasource.models.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CentralRepository {
	@Select("SELECT * FROM payments")
	List<Payment> getPayments();
}