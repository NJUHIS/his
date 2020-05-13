package com.njuhis.his.controller;

import com.njuhis.his.HisApplication;
import com.njuhis.his.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/** 
* AdministrationController Tester. 
* 
* @author <Authors name> 
* @since <pre>五月 7, 2020</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HisApplication.class)
public class AdministrationControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;
@Before
public void before() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    session = new MockHttpSession();
    User admin = new User();
    session.setAttribute("user",admin);
    Thread.sleep(1890);
}
    @Test
    public void testGetDepartmentAndDoctor() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/AdministrationController/getDepartmentAndDoctor")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @After
public void after() throws Exception { 
} 

/** 
* 
* Method: initBinder(WebDataBinder binder, WebRequest request) 
* 
*/ 
@Test
public void testInitBinder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getDepartmentAndDoctor(HttpServletResponse httpServletResponse) 
* 
*/ 

/** 
* 
* Method: getReceivableAccounts(@RequestBody CostVo costVo, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetReceivableAccounts() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getReceivableAccountsByDays(@RequestParam Integer id, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetReceivableAccountsByDays() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getReceivableAccountsByWeeks(@RequestParam Integer id, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetReceivableAccountsByWeeks() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getReceivableAccountsByMonths(@RequestParam Integer id, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetReceivableAccountsByMonths() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getReceivedAccounts(@RequestBody CostVo costVo, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetReceivedAccounts() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPatAccount(@RequestBody PatientVo patientVo, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetPatAccount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getPatientCostList(@RequestParam Integer currPage, @RequestParam String conditions, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetPatientCostList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getCheckDetailedList(@RequestParam Integer id, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetCheckDetailedList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRegisterList(@RequestParam Integer currPage, @RequestParam String conditions, HttpServletResponse httpServletResponse) 
* 
*/ 
@Test
public void testGetRegisterList() throws Exception { 
//TODO: Test goes here... 
} 


} 
