package com.mvc.test.controller.test;

import com.mvc.test.model.Customer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
@ContextConfiguration(locations = {
        "classpath:mvc-dispatcher-servlet.xml"
})
public class SignUpControllerTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;



    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Before
    public void setUp() throws Exception
    {
        this.request = new MockHttpServletRequest();
        request.setContentType("application/json");
        this.response = new MockHttpServletResponse();
    }

    @Test
    public void testSignUp(){
        request.setMethod("POST");
        request.setRequestURI("/signup");

        final ModelAndView mav;
        Object handler;
        try
        {
            request.setParameter("customers[0].name", "Test 1");
            request.setParameter("customers[0].age","11");

            request.setParameter("customers[1].name", "Test 2");
            request.setParameter("customers[1].age","12");

            handler = handlerMapping.getHandler(request).getHandler();
            mav = handlerAdapter.handle(request, response, handler);
            Assert.assertEquals(200, response.getStatus());
        }
        catch (Exception e){
             e.printStackTrace();
        }
    }

}
