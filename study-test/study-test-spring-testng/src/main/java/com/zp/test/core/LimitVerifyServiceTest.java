package com.zp.test.core;

import com.payment.lc.limit.service.api.LimitVerifyService;
import com.payment.lc.limit.service.enums.VerifyType;
import com.payment.lc.limit.service.request.VerifyRequest;
import com.payment.lc.limit.service.response.VerifyResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Author: Zhang Peng
 * Date: 2017/3/9 0009
 * Description: TODO please add description.
 */
@ContextConfiguration({"/context/applicationContext.xml"})
public class LimitVerifyServiceTest extends AbstractTestNGSpringContextTests {

    private static final Logger logger = Logger.getLogger(LimitVerifyServiceTest.class);

    @Autowired
    private LimitVerifyService limitVerifyService;

    @Test
    public void limitVerify() {
        VerifyRequest verifyRequest = new VerifyRequest();
        verifyRequest.setVerifyType(VerifyType.IS_SELLOUT);
        verifyRequest.setProductionCode("JM110007");
        VerifyResponse response = limitVerifyService.limitVerify(verifyRequest);
        logger.info(response);
    }

}
