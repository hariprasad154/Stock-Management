package com.stockexchange.stockecmarker.srvice;

import com.stockexchange.stockecmarker.dto.AllertStock;
import com.stockexchange.stockecmarker.dto.Mydto;
import com.stockexchange.stockecmarker.dto.ResponceDto;

public interface service {
    ResponceDto addStock(Mydto mydto);

    ResponceDto editData(int id,Mydto mydto);

    ResponceDto getAllData();

    ResponceDto getDataById(int id);

    String deleteDataById(int id);

    AllertStock alert();
}
