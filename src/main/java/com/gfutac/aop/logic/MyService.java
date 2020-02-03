package com.gfutac.aop.logic;

import com.gfutac.aop.aspect.SimpleAspect;
import com.gfutac.aop.aspect.PerformanceLog;
// import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
// lombok not used in classes that will be processed by AJC
// @Slf4j
public class MyService {

    private static final Logger log = LoggerFactory.getLogger(SimpleAspect.class);

    @PerformanceLog
    public void serviceMethodA(int a, int b, int c) {
        log.info("Invoking serviceMethodB.");
        this.serviceMethodB();
    }

    @PerformanceLog
    public void serviceMethodB() {
        log.info("serviceMethodB invoked.");
    }
}
