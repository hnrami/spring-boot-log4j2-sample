package com.sophos.nsg.jtaf.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.sophos.nsg.jtaf.devices.SFOS;

/**
 * Test class for testing Sep Integration
 *
 */
public class CustomReportConfigurationTest extends TestBase
{

		SFOS sep;

	    @BeforeClass(alwaysRun = true)
	    void setUp()
	        throws Exception
	    {
	        sep = (SFOS) _environment.getFirewall();

	        
	    }

	    @Test(groups = { "reporting", "CustomReportConfiguration",
	                    "team_iview" }, description = "Test creation of CustomReportConfiguration object with SEP")
	    void testCustomReportConfiguration()
	        throws Exception
	    {
	        // Create CustomReportConfiguration using JsonObject
	        JsonObject jsonObj = new JsonObject();
	        jsonObj.addProperty("type", "CustomReportConfiguration");
	        jsonObj.addProperty("reportId", "25");
	        jsonObj.addProperty("reportName", "CUST");
	        jsonObj.addProperty("parentReportId", "1");
	        jsonObj.addProperty("reportJson", "{'id':'1','name':'test'}");
	       
	        jsonObj = sep.createEntity(jsonObj);
	        String rwsId = jsonObj.get("id")
	                              .getAsString();
	        assertTrue(rwsId != null, "Config : Failed to create CustomReportConfiguration object.");

	        // Update CustomReportConfiguration using JsonObject
	        jsonObj = new JsonObject();
	        jsonObj.addProperty("type", "CustomReportConfiguration");
	       

	        jsonObj = sep.updateEntity(rwsId, jsonObj);
	        rwsId = jsonObj.get("id")
	                       .getAsString();
	        assertTrue(rwsId != null, "Config : Failed to update CustomReportConfiguration object.");

	        jsonObj = null;
	        jsonObj = sep.readEntity(rwsId);
	       

	        assertTrue(sep.deleteEntity(rwsId), "Config : Failed to delete CustomReportConfiguration Ojbect.");
	    }   
   

}
