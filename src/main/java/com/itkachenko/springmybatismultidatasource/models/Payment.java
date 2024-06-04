package com.itkachenko.springmybatismultidatasource.models;

import java.sql.Timestamp;

public record Payment(Long id, Long amount, Timestamp date) {}
