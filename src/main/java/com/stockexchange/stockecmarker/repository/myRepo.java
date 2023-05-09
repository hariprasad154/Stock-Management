package com.stockexchange.stockecmarker.repository;

import com.stockexchange.stockecmarker.model.myModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface myRepo extends JpaRepository<myModel,Integer> {
    @Query(value = "SELECT * FROM stockmarker.my_model where name = :stock",nativeQuery = true)
    myModel findStockByName(String stock);
}
