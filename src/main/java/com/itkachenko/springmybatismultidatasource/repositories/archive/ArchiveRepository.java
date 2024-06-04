package com.itkachenko.springmybatismultidatasource.repositories.archive;

import com.itkachenko.springmybatismultidatasource.models.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArchiveRepository {
	@Select("SELECT * FROM payments_archive")
	List<Payment> getPayments();
}