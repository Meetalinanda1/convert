package com.sap.cap.celsius.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

@Component
@ServiceName("CelsiusService")
public class CelsiusService implements EventHandler {

    private Map<Object, Map<String, Object>> cels = new HashMap<>();

    @On(event = CdsService.EVENT_CREATE, entity = "CelsiusService.Celsius")
    public void onCreate(CdsCreateEventContext context) {
        context.getCqn().entries().forEach(e -> cels.put(e.get("ID"), e));
        context.setResult(context.getCqn().entries());
    }

    @On(event = CdsService.EVENT_READ, entity = "CelsiusService.Celsius")
    public void onRead(CdsReadEventContext context) {
        context.setResult(cels.values());
    }

}