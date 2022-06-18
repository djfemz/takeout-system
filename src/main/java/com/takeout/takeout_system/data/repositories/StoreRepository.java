package com.takeout.takeout_system.data.repositories;

import com.takeout.takeout_system.data.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
