package com.cmrs.backend.repository;

import com.cmrs.backend.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository
        extends JpaRepository<Setting, Long> {

}