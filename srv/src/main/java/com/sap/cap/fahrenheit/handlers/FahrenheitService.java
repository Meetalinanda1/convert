package com.sap.cap.fahrenheit.handlers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.cds.Result;
import com.sap.cds.ql.Insert;
import com.sap.cds.ql.Select;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.persistence.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//import cds.gen.celsiusservice.Celsius;
//import cds.gen.celsiusservice.CelsiusService_;
//import cds.gen.celsiusservice.Celsius_;
import cds.gen.fahrenheitservice.Fahrenheit;
import cds.gen.fahrenheitservice.Fahrenheit_;
import cds.gen.fahrenheitservice.Celsius1;
import cds.gen.fahrenheitservice.Celsius1_;
import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

@Component
@ServiceName("FahrenheitService")
public class FahrenheitService implements EventHandler {
    @Autowired
    PersistenceService db;
   

    


    @After(event = { CdsService.EVENT_READ, CdsService.EVENT_CREATE }, entity = "FahrenheitService.Fahrenheit")
    public void calculateFahrenheitValue(List<Fahrenheit> fah) {
        for (Fahrenheit item : fah) {
            Integer celId = item.getCelsiusid();
            CqnSelect sel = Select.from(Celsius1_.class).where(b -> b.ID().eq(celId));
            Celsius1 celsius = db.run(sel).single(Celsius1.class);
            double celinput =  celsius.getCelsiusinput();
            double fahoutput = (celinput*1.8) +32 ;//0.18 + 32 ;

            item.setFahrenheitoutput(fahoutput);

        }
    }

}