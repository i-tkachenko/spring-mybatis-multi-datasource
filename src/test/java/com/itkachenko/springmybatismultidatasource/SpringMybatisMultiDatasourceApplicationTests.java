package com.itkachenko.springmybatismultidatasource;

import com.itkachenko.springmybatismultidatasource.models.Payment;
import com.itkachenko.springmybatismultidatasource.repositories.archive.ArchiveRepository;
import com.itkachenko.springmybatismultidatasource.repositories.central.CentralRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class SpringMybatisMultiDatasourceApplicationTests {
	@Autowired
	ArchiveRepository archiveRepository;
	@Autowired
	CentralRepository centralRepository;

	@Test
	void testMultiDatasourcePayments() {
		// Act: Retrieve payments from both repositories
		List<Payment> archivePayments = archiveRepository.getPayments();
		List<Payment> centralPayments = centralRepository.getPayments();

		// Assert: Verify the results
		assertFalse(archivePayments.isEmpty(), "Archive payments should not be empty");
		assertFalse(centralPayments.isEmpty(), "Central payments should not be empty");
		assertNotEquals(archivePayments, centralPayments, "Payments from archive and central repositories should not be equal");
	}
}
