package com.cmrs.backend.repository;

import com.cmrs.backend.entity.ResidentRoomHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRoomHistoryRepository
        extends JpaRepository<ResidentRoomHistory, Long> {

}