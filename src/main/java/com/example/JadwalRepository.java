package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface JadwalRepository extends JpaRepository<Jadwal, Long> {

    @Transactional
    void deleteByDone(boolean done);
}
