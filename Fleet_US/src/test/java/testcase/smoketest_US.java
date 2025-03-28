package testcase;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Random;
import java.nio.file.Paths;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import action.Baseclass;
import Pages.Login;
import java.awt.*;

public class smoketest_US extends Baseclass{
	
	LocalDate currentDate = LocalDate.now();
	int day = currentDate.getDayOfMonth();
	int month = currentDate.getMonthValue();
	int year = currentDate.getYear();
	
	Random rand = new Random();
    int randomNum = rand.nextInt(900) + 100;
    String vehicle= "ABC "+randomNum;
	@Test(priority=1)
	public void login()
	{
		Login l1= new Login(driver);
		l1.clietid();
		l1.username();
		l1.password();
		l1.loginbutton();
		click("#usrpicofcorner");
		click("#settingsLabel");
		click("//span[contains(text(),'Fleet management')]");
	}
	@Test(priority=2)
	public void Settings_status() throws InterruptedException
	{
		String Vehiclestatus= "Status "+randomNum;
		//Add vehicle status
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/vehicle_status\"]");
		click("//button[contains(text(),'Add new vehicle status')]");
		Thread.sleep(3000);
		type("//input[@formcontrolname='name']", Vehiclestatus);
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(3000);
		//Edit vehicle status
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]", Vehiclestatus);
		Thread.sleep(5000);
		//ExplicitWait_ElementToBeClickable("(//a[contains(text(),'Edit')])[2]");
		click("(//a[contains(text(),'Edit')])[2]");
		type("//input[@formcontrolname='name']", " edit");
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(2000);
		//delete vehicle status
		click("(//input[@type=\"search\"])[2]");
		type("(//input[@type=\"search\"])[2]", Vehiclestatus);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class='btn-medium btn btn-danger']");
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new vehicle status')]");
		Thread.sleep(3000);
		type("//input[@formcontrolname='name']", Vehiclestatus);
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=3)
	public void Settings_type()  throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String Vehicletype= "Type "+randomNum;
		// Add vehicle type
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/vehicle_types\"]");
		click("//button[contains(text(),'Add new vehicle type')]");
		Thread.sleep(3000);
		type("//input[@formcontrolname='type']", Vehicletype);
		click("//button[@class=\"btn btn-primary save-btn\"]");
		Thread.sleep(3000);
		//Edit vehicle type
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]", Vehicletype);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Edit')])[2]");
		type("//input[@formcontrolname='type']", " edit");
		click("//button[@class=\"btn btn-primary save-btn\"]");
		Thread.sleep(2000);
		//delete vehicle type
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]", Vehicletype);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class='btn-medium btn btn-danger']");
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new vehicle type')]");
		Thread.sleep(3000);
		type("//input[@formcontrolname='type']", Vehicletype);
		click("//button[@class=\"btn btn-primary save-btn\"]");
		Thread.sleep(2000);
		
		
	}
	
	@Test(priority=4)
	public void Settings_Make() throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String Vehiclemake= "Make "+randomNum;
		//Add vehicle make
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/vehicle_makes\"]");
		click("//button[contains(text(),'Add new vehicle make')]");
		Thread.sleep(3000);
		type("//input[@formcontrolname='name']", Vehiclemake);
		click("//button[@class=\"btn btn-primary make-save-btn\"]");
		Thread.sleep(3000);
		//Edit vehicle make
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]",Vehiclemake);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Edit')])[2]");
		type("//input[@formcontrolname='name']", " edit");
		click("//button[@class=\"btn btn-primary make-save-btn\"]");
		Thread.sleep(2000);
		//Delete vehicle make
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]", Vehiclemake);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class='btn-medium btn btn-danger']");
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new vehicle make')]");
		Thread.sleep(3000);
		type("//input[@formcontrolname='name']", Vehiclemake);
		click("//button[@class=\"btn btn-primary make-save-btn\"]");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=5)
	public void Settings_Model() throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String Vehiclemodel= "Model "+randomNum;
		String Vehiclemake= "Make "+randomNum;
		//Add vehicle model
		Thread.sleep(2000);
		click("//a[@href='system_settings/vehicle_models']");
		click("//button[contains(text(),'Add new vehicle model')]");
		Thread.sleep(3000);
		click("//select[@formcontrolname='makes']");
		type("//select[@formcontrolname='makes']", Vehiclemake);
		typeenter("//select[@formcontrolname='makes']");
		Thread.sleep(2000);
		type("//input[@formcontrolname='modelName']", Vehiclemodel);
		click("//button[@class=\"btn btn-primary model-save-btn\"]");
		Thread.sleep(3000);
		//Edit vehicle model
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type='search'])[2]",Vehiclemodel);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Edit')])[2]");
		type("//input[@formcontrolname='modelName']", " edit");
		click("//button[@class=\"btn btn-primary model-save-btn\"]");
		Thread.sleep(2000);
		//Delete vehicle model
		click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]", Vehiclemodel);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class='btn-medium btn btn-danger']");
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new vehicle model')]");
		Thread.sleep(3000);
		click("//select[@formcontrolname='makes']");
		type("//select[@formcontrolname='makes']", Vehiclemake);
		typeenter("//select[@formcontrolname='makes']");
		Thread.sleep(2000);
		type("//input[@formcontrolname='modelName']", Vehiclemodel);
		click("//button[@class=\"btn btn-primary model-save-btn\"]");
		Thread.sleep(3000);
		
	}
	@Test(priority=6)
	public void Settings_CheckForm() throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String Checkform= "Checkform "+randomNum;
		String failurename= "Failure "+randomNum;
		//Add check form
		//Basic details
		Thread.sleep(2000);
		click("//a[@href='system_settings/vehicle_check_forms']");
		click("//a[contains(text(),'Add new vehicle check form')]");
		Thread.sleep(2000);
		click("//input[@formcontrolname='templateName']");
		type("//input[@formcontrolname='templateName']", Checkform);
		click("//textarea[@formcontrolname='description']");
		type("//textarea[@formcontrolname='description']", "Description");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
	    Thread.sleep(2000);
		//Delete check form
	    click("//input[@id=\"folder-search\"]");
		Thread.sleep(2000);
		type("//input[@id=\"folder-search\"]", Checkform);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class=\"btn btn-medium btn-danger\"]");
		Thread.sleep(2000);
		//Add check form
	   //Basic details
		Thread.sleep(2000);
		click("//a[contains(text(),'Add new vehicle check form')]");
		Thread.sleep(2000);
		click("//input[@formcontrolname='templateName']");
		type("//input[@formcontrolname='templateName']", Checkform);
		click("//textarea[@formcontrolname='description']");
		type("//textarea[@formcontrolname='description']", "Description");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Mobile form design
		Thread.sleep(2000);
		click("//a[@class=\"btn btn-small add-btn no-page\"]");
		click("//input[@formcontrolname='pageName']");
		type("//input[@formcontrolname='pageName']", "Page one");
		click("//button[@type='submit']");
		Thread.sleep(3000);
		dd("(//div[@class=\"elem-item\"])[4]", "//div[@class='warning-block']");
		type("//input[@formcontrolname=\"fieldLabel\"]", "Textbox one");
		click("//button[@class=\"btn btn-primary primary-button\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Failure criteria
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary btn-small button-float add-button\"]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"name\"]", failurename);
		click("//a[@class=\"condition-link\"]");
		click("(//span[@class=\"select2-chosen\"])[2]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Textbox one");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@formcontrolname=\"value\"]", "Test check form");
		click("//button[@class=\"btn btn-primary\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Notification
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"emailType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
		type("//input[@placeholder=\"Search folders and templates\"]", "vehicle form test");
		Thread.sleep(2000);
		typeenter("//input[@placeholder=\"Search folders and templates\"]");
		Thread.sleep(2000);
		click("//span[@class=\"folder-name\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("(//a[contains(text(),'Settings')])[2]");
	}
	
	@Test(priority=7)
	public void Settings_reminder()throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String remindername= "Reminder "+randomNum;
		//Add reminder
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/vehicle_reminder\"]");
		click("//button[contains(text(),'Add new reminder')]");
		type("//input[@formcontrolname=\"name\"]", remindername);
		type("//input[@formcontrolname=\"timeInterval\"]", "1");
		type("//input[@formcontrolname=\"timeReminder\"]", "1");
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Delete check form
		Thread.sleep(3000);
	    click("(//input[@type=\"search\"])[2]");
		Thread.sleep(1000);
		type("(//input[@type=\"search\"])[2]", remindername);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class=\"btn-medium btn btn-danger delete-btn\"]");
		//Add reminder
		Thread.sleep(3000);
		click("//button[contains(text(),'Add new reminder')]");
		type("//input[@formcontrolname=\"name\"]", remindername);
		type("//input[@formcontrolname=\"timeInterval\"]", "1");
		type("//input[@formcontrolname=\"timeReminder\"]", "1");
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(1000);
		click("(//input[@formcontrolname=\"emailType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
		type("//input[@placeholder=\"Search folders and templates\"]", "Reminder email ");
		Thread.sleep(2000);
		typeenter("//input[@placeholder=\"Search folders and templates\"]");
		Thread.sleep(2000);
		click("//span[@class=\"folder-name\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("(//a[contains(text(),'Settings')])[2]");
		
	}
	
	@Test(priority=8)
	public void Settings_checktemplate()throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String checktempalte= "Checktemplate "+randomNum;
		//Add check template
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/vehicle_check_template\"]");
		click("//button[contains(text(),'Add new vehicle check template')]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"templateName\"]", checktempalte);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		click("(//a[@class=\"link-color pointer-cursor\"])[1]");
		click("//span[contains(text(),'Mon')]");
		selectdropdownvalue("//select[@formcontrolname=\"repeats\"]", "4");
		selectdropdownvalue("//select[@formcontrolname=\"vehicleCheckForm\"]", "2");
		selectdropdownvalue("//select[@formcontrolname=\"vehicleCheckMissed\"]", "1");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Delete check template
		Thread.sleep(3000);
	    click("(//input[@type=\"search\"])[2]");
		Thread.sleep(1000);
		type("(//input[@type=\"search\"])[2]", checktempalte);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class=\"btn-medium btn btn-danger\"]");
		//Add check template
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new vehicle check template')]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"templateName\"]", checktempalte);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		click("(//a[@class=\"link-color pointer-cursor\"])[2]");
		selectdropdownvalue("//select[@formcontrolname=\"scheduleType\"]", "2");
		click("//input[@value=\"First\"]");
		click("(//span[contains(text(),'Mon')])[2]");
		click("//span[contains(text(),'Tue')]");
		selectdropdownvalue("//select[@formcontrolname=\"vehicleCheckForm\"]", "2");
		selectdropdownvalue("//select[@formcontrolname=\"vehicleCheckMissed\"]", "1");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("(//a[contains(text(),'Settings')])[2]");
	}
	
	@Test(priority=9)
	public void Settings_maintenance()throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String maintenance= "Maintenance "+randomNum;
		//Add setting maintenance
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/vehicle_maintenance\"]");
		click("//button[contains(text(),'Add new maintenance')]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"name\"]", maintenance);
		selectdropdownvalue("//select[@formcontrolname=\"priority\"]", "Low");
		type("//input[@formcontrolname=\"timeInterval\"]", "1");
		type("//input[@formcontrolname=\"timeReminder\"]", "1");
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Delete maintenance
		Thread.sleep(3000);
	    click("(//input[@type=\"search\"])[2]");
		Thread.sleep(1000);
		type("(//input[@type=\"search\"])[2]", maintenance);
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class=\"btn-medium btn btn-danger\"]");
		//Add maintenance
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new maintenance')]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"name\"]", maintenance);
		selectdropdownvalue("//select[@formcontrolname=\"priority\"]", "Low");
		type("//input[@formcontrolname=\"timeInterval\"]", "1");
		type("//input[@formcontrolname=\"timeReminder\"]", "1");
		type("//input[@formcontrolname=\"mileageInterval\"]", "100");
		type("//input[@formcontrolname=\"mileageReminder\"]", "50");
		click("//button[@class=\"btn btn-primary staus-save-btn\"]");
		Thread.sleep(2000);
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"emailType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
		type("//input[@placeholder=\"Search folders and templates\"]", "Vehicle maintenance");
		Thread.sleep(2000);
		typeenter("//input[@placeholder=\"Search folders and templates\"]");
		Thread.sleep(2000);
		click("//span[@class=\"folder-name\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		Thread.sleep(2000);
		click("(//a[contains(text(),'Settings')])[2]");
	}
	
	@Test(priority=10)
	public void settings_geofence()throws InterruptedException
	{
		click("(//a[contains(text(),'Settings')])[2]");
		String geofence= "Geofence "+randomNum;
		//Add setting geofence
		Thread.sleep(2000);
		click("//a[@href=\"system_settings/fleet/geo-fences\"]");
		click("//button[contains(text(),'Add new geo-fence')]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"name\"]", geofence);
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("//a[contains(text(),'Set around location')]");
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("(//input[@name=\"checkbox-unchecked\"])[1]");
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"assignTo\"])[2]");
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("(//input[@name=\"checkbox-unchecked\"])[1]");
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(3000);
		click("//i[@class=\"far fa-xmark\"]");
		
		//Delete fence
		Thread.sleep(3000);
	    click("(//input[@type=\"search\"])[2]");
		Thread.sleep(1000);
		type("(//input[@type=\"search\"])[2]", geofence);
		Thread.sleep(2000);
		click("(//span[contains(text(),'Delete')])[1]");
		type("//input[@formcontrolname=\"confirmationText\"]", "Delete");
		click("//button[@class=\"btn btn-danger\"]");
		//Add setting geofence
		Thread.sleep(2000);
		click("//button[contains(text(),'Add new geo-fence')]");
		Thread.sleep(2000);
		type("//input[@formcontrolname=\"name\"]", geofence);
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("//a[contains(text(),'Set around location')]");
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("(//input[@name=\"checkbox-unchecked\"])[1]");
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"assignTo\"])[2]");
		click("//button[@class=\"btn btn-primary save_btn\"]");
		Thread.sleep(2000);
		click("(//input[@name=\"checkbox-unchecked\"])[1]");
		click("(//input[@name=\"checkbox-unchecked\"])[2]");
		click("(//input[@formcontrolname=\"emailType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
		type("//input[@placeholder=\"Search folders and templates\"]", "Geo-fence");
		Thread.sleep(2000);
		typeenter("//input[@placeholder=\"Search folders and templates\"]");
		Thread.sleep(2000);
		click("//span[@class=\"folder-name\"]");
		Thread.sleep(2000);
		click("(//input[@formcontrolname=\"notificationType\"])[1]");
		Thread.sleep(2000);
		click("//input[@class=\"select2-input select2-default\"]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(3000);
		click("//i[@class=\"far fa-xmark\"]");
		Thread.sleep(2000);
		click("(//a[contains(text(),'Settings')])[2]");
	}
	
	@Test(priority=11)
	public void settings_out_of_hours()throws InterruptedException
	{
		Thread.sleep(2000);
		click("(//a[contains(text(),'Settings')])[2]");
		click("//a[@href=\"system_settings/vehicle_out_of_hours\"]");
        WebElement checkbox = driver.findElement(By.xpath("(//input[@formcontrolname=\"checked\"])[1]"));
        if (checkbox.isSelected()) {
        	System.out.println("monday is checked");
        	//Uncheck and save
        	Thread.sleep(3000);
    		click("//span[contains(text(),'Monday')]");
    		Thread.sleep(2000);
            WebElement body5 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body5.sendKeys(Keys.END);
            Thread.sleep(2000);
        	click("(//input[@formcontrolname=\"emailType\"])[4]");
        	WebElement body6 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body6.sendKeys(Keys.END);
        	click("(//input[@formcontrolname=\"notificationType\"])[3]");
    		Thread.sleep(2000);
    		click("//button[@class=\"btn btn-primary no-margin\"]");
    		//check and save
    		Thread.sleep(3000);
    		click("//a[@href=\"system_settings/vehicle_out_of_hours\"]");
    		click("//span[contains(text(),'Monday')]");
        	selectdropdownvalue("//select[@formcontrolname=\"startTime\"]", "0");
        	WebElement body7 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body7.sendKeys(Keys.END);
            Thread.sleep(2000);
        	click("(//input[@formcontrolname=\"emailType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		WebElement body8 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body8.sendKeys(Keys.END);
    		Thread.sleep(2000);
    		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
    		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
    		type("//input[@placeholder=\"Search folders and templates\"]", "Out-of-hours");
    		Thread.sleep(2000);
    		typeenter("//input[@placeholder=\"Search folders and templates\"]");
    		Thread.sleep(2000);
    		click("//span[@class=\"folder-name\"]");
    		Thread.sleep(2000);
    		click("(//input[@formcontrolname=\"notificationType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		click("//button[@class=\"btn btn-primary no-margin\"]");
            
        } else {
        	System.out.println("Monday is unchecked");
        	//Checked and saved
            click("//span[contains(text(),'Monday')]");
        	selectdropdownvalue("//select[@formcontrolname=\"startTime\"]", "0");
        	Thread.sleep(2000);
        	WebElement body1 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body1.sendKeys(Keys.END);
            Thread.sleep(2000);
            WebElement radio1 = driver.findElement(By.xpath("(//input[@formcontrolname=\"emailType\"])[1]"));
            WebElement radio2 = driver.findElement(By.xpath("(//input[@formcontrolname=\"notificationType\"])[1]"));
            if(radio1.isSelected() || radio2.isSelected())
            {
            	click("//button[@class=\"btn btn-primary no-margin\"]");
            }
            else
            {
        	click("(//input[@formcontrolname=\"emailType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		WebElement body2 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body2.sendKeys(Keys.END);
    		Thread.sleep(2000);
    		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
    		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
    		type("//input[@placeholder=\"Search folders and templates\"]", "Out-of-hours");
    		Thread.sleep(2000);
    		typeenter("//input[@placeholder=\"Search folders and templates\"]");
    		Thread.sleep(2000);
    		click("//span[@class=\"folder-name\"]");
    		Thread.sleep(2000);
    		click("(//input[@formcontrolname=\"notificationType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		click("//button[@class=\"btn btn-primary no-margin\"]");
            }
            
    		//Unchecked and saved
    		Thread.sleep(3000);
    		click("//a[@href=\"system_settings/vehicle_out_of_hours\"]");
    		Thread.sleep(2000);
    		click("//span[contains(text(),'Monday')]");
    		Thread.sleep(2000);
            WebElement body3 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body3.sendKeys(Keys.END);
            Thread.sleep(2000);
        	click("(//input[@formcontrolname=\"emailType\"])[4]");
        	WebElement body4 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body4.sendKeys(Keys.END);
        	click("(//input[@formcontrolname=\"notificationType\"])[3]");
    		Thread.sleep(2000);
    		click("//button[@class=\"btn btn-primary no-margin\"]");
            
        }

	}
	
	@Test(priority=12)
	public void settings_engineerdepature()throws InterruptedException
	{
		Thread.sleep(3000);
		click("(//a[contains(text(),'Settings')])[2]");
		click("//a[@href=\"system_settings/departure_notification\"]");
		Thread.sleep(5000);
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id=\"yesDepartureNotify\"]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id=\"noDepartureNotify\"]"));
		
        if (checkbox1.isSelected())
        {
        	System.out.println("Yes is checked");
        	Thread.sleep(2000);
        	click("//label[@for=\"noDepartureNotify\"]");
            click("//button[@class=\"btn btn-primary no-margin\"]");
            Thread.sleep(2000);
            click("//a[@href=\"system_settings/departure_notification\"]");
            Thread.sleep(2000);
        	click("//label[@for=\"yesDepartureNotify\"]");
        	selectdropdownvalue("//select[@formcontrolname=\"notifyMinute\"]", "0");
        	WebElement body3 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body3.sendKeys(Keys.END);
            WebElement radio1 = driver.findElement(By.xpath("(//input[@formcontrolname=\"emailType\"])[1]"));
            WebElement radio2 = driver.findElement(By.xpath("(//input[@formcontrolname=\"notificationType\"])[1]"));
            if(radio1.isSelected() || radio2.isSelected())
            {
            	click("//button[@class=\"btn btn-primary no-margin\"]");
            }
            else
            {
        	click("(//input[@formcontrolname=\"emailType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		WebElement body2 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body2.sendKeys(Keys.END);
    		Thread.sleep(2000);
    		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
    		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
    		type("//input[@placeholder=\"Search folders and templates\"]", "Engineer departure");
    		Thread.sleep(2000);
    		typeenter("//input[@placeholder=\"Search folders and templates\"]");
    		Thread.sleep(2000);
    		click("//span[@class=\"folder-name\"]");
    		Thread.sleep(2000);
    		click("(//input[@formcontrolname=\"notificationType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		click("//button[@class=\"btn btn-primary no-margin\"]");
            }
        	
        	  	
        }
        
        else if (checkbox2.isSelected())
        {
        	System.out.println("No is checked");
        	Thread.sleep(2000);
        	click("//label[@for=\"yesDepartureNotify\"]");
        	selectdropdownvalue("//select[@formcontrolname=\"notifyMinute\"]", "0");
        	WebElement body3 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body3.sendKeys(Keys.END);
            WebElement radio1 = driver.findElement(By.xpath("(//input[@formcontrolname=\"emailType\"])[1]"));
            WebElement radio2 = driver.findElement(By.xpath("(//input[@formcontrolname=\"notificationType\"])[1]"));
            if(radio1.isSelected() || radio2.isSelected())
            {
            	click("//button[@class=\"btn btn-primary no-margin\"]");
            }
            else
            {
        	click("(//input[@formcontrolname=\"emailType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		WebElement body2 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
            body2.sendKeys(Keys.END);
    		Thread.sleep(2000);
    		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
    		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
    		type("//input[@placeholder=\"Search folders and templates\"]", "Engineer departure");
    		Thread.sleep(2000);
    		typeenter("//input[@placeholder=\"Search folders and templates\"]");
    		Thread.sleep(2000);
    		click("//span[@class=\"folder-name\"]");
    		Thread.sleep(2000);
    		click("(//input[@formcontrolname=\"notificationType\"])[1]");
    		Thread.sleep(2000);
    		click("//input[@class=\"select2-input select2-default\"]");
    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
    		typeenter("//input[@class=\"select2-input select2-focused\"]");
    		click("//button[@class=\"btn btn-primary no-margin\"]");
            }
        
            Thread.sleep(2000);
            click("//a[@href=\"system_settings/departure_notification\"]");
            Thread.sleep(2000);
            click("//label[@for=\"noDepartureNotify\"]");
            click("//button[@class=\"btn btn-primary no-margin\"]");
        }
        else
        {
        	System.out.println("nothing is checked");
        	
        }
	}
	
	@Test(priority=13)
	public void settings_late_arrival()throws InterruptedException
	{
		Thread.sleep(3000);
		click("(//a[contains(text(),'Settings')])[2]");
		click("//a[@href=\"system_settings/late_arrival_notification\"]");
		Thread.sleep(7000);
		WebElement checkbox1 = driver.findElement(By.xpath("//input[@id=\"yesDepartureNotify\"]"));
		WebElement checkbox2 = driver.findElement(By.xpath("//input[@id=\"noDepartureNotify\"]"));
		 if (checkbox1.isSelected())
		 {
			 
			 System.out.println("Yes is checked");
	        	Thread.sleep(2000);
	        	click("//label[@for=\"noDepartureNotify\"]");
	            click("//button[@class=\"btn btn-primary no-margin\"]");
	            Thread.sleep(2000);
	            click("//a[@href=\"system_settings/late_arrival_notification\"]");
	            Thread.sleep(2000);
	        	click("//label[@for=\"yesDepartureNotify\"]");
	            WebElement radio1 = driver.findElement(By.xpath("(//input[@formcontrolname=\"emailType\"])[1]"));
	            WebElement radio2 = driver.findElement(By.xpath("(//input[@formcontrolname=\"notificationType\"])[1]"));
	            if(radio1.isSelected() || radio2.isSelected())
	            {
	            	click("//button[@class=\"btn btn-primary no-margin\"]");
	            }
	            else
	            {
	        	click("(//input[@formcontrolname=\"emailType\"])[1]");
	    		Thread.sleep(2000);
	    		click("//input[@class=\"select2-input select2-default\"]");
	    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
	    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
	    		typeenter("//input[@class=\"select2-input select2-focused\"]");
	    		WebElement body2 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
	            body2.sendKeys(Keys.END);
	    		Thread.sleep(2000);
	    		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
	    		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
	    		type("//input[@placeholder=\"Search folders and templates\"]", "Late arrival");
	    		Thread.sleep(2000);
	    		typeenter("//input[@placeholder=\"Search folders and templates\"]");
	    		Thread.sleep(2000);
	    		click("//span[@class=\"folder-name\"]");
	    		Thread.sleep(2000);
	    		WebElement body3 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
	            body2.sendKeys(Keys.END);
	    		click("(//input[@formcontrolname=\"notificationType\"])[1]");
	    		Thread.sleep(2000);
	    		click("//input[@class=\"select2-input select2-default\"]");
	    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
	    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
	    		typeenter("//input[@class=\"select2-input select2-focused\"]");
	    		click("//button[@class=\"btn btn-primary no-margin\"]");
	            }
	            
		 }
		 else if(checkbox2.isSelected())
		 {
			 System.out.println("No is checked");
	        	Thread.sleep(2000);
	        	click("//label[@for=\"yesDepartureNotify\"]");
	            WebElement radio1 = driver.findElement(By.xpath("(//input[@formcontrolname=\"emailType\"])[1]"));
	            WebElement radio2 = driver.findElement(By.xpath("(//input[@formcontrolname=\"notificationType\"])[1]"));
	            if(radio1.isSelected() || radio2.isSelected())
	            {
	            	click("//button[@class=\"btn btn-primary no-margin\"]");
	            }
	            else
	            {
	        	click("(//input[@formcontrolname=\"emailType\"])[1]");
	    		Thread.sleep(2000);
	    		click("//input[@class=\"select2-input select2-default\"]");
	    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
	    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
	    		typeenter("//input[@class=\"select2-input select2-focused\"]");
	    		WebElement body2 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
	            body2.sendKeys(Keys.END);
	    		Thread.sleep(2000);
	    		click("//a[@class='btn dropdown-toggle padding-none float-left mlr-5']");
	    		ExplicitWait_ElementToBeClickable("//input[@placeholder=\"Search folders and templates\"]");
	    		type("//input[@placeholder=\"Search folders and templates\"]", "Late arrival");
	    		Thread.sleep(2000);
	    		typeenter("//input[@placeholder=\"Search folders and templates\"]");
	    		Thread.sleep(2000);
	    		click("//span[@class=\"folder-name\"]");
	    		Thread.sleep(2000);
	    		WebElement body3 = driver.findElement(By.xpath("//div[@class=\"fleet-notification-container\"]"));
	            body2.sendKeys(Keys.END);
	    		click("(//input[@formcontrolname=\"notificationType\"])[1]");
	    		Thread.sleep(2000);
	    		click("//input[@class=\"select2-input select2-default\"]");
	    		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
	    		type("//input[@class=\"select2-input select2-focused\"]", "srimaya suresh");
	    		typeenter("//input[@class=\"select2-input select2-focused\"]");
	    		click("//button[@class=\"btn btn-primary no-margin\"]");
	            }
	            Thread.sleep(2000);
	            click("//a[@href=\"system_settings/late_arrival_notification\"]");
	            Thread.sleep(2000);
	            click("//label[@for=\"noDepartureNotify\"]");
	            click("//button[@class=\"btn btn-primary no-margin\"]");
	            
		 }
		 else
		 {
			 System.out.println("Error in late arrival");
		 }
		 
	}
	
	@Test(priority=14)
	public void addVehicle()throws InterruptedException
	{
		String vehilename= "Vehicle " +day+month;
		//Add vehicle
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary btn-small button-float add-button\"]");
		Thread.sleep(2000);
		//Basic details
		type("//input[@formcontrolname=\"registrationNumber\"]", vehicle);
		type("//input[@formcontrolname=\"vin\"]", "1N6SD11S4LC427846");
		type("//input[@formcontrolname=\"vehicleName\"]", vehilename);
		click("(//span[@class=\"select2-chosen\"])[2]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Lorry");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[3]");
		click("(//span[@class=\"select2-chosen\"])[3]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Ford");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//a[@class=\"select2-choice\"])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		ExplicitWait_ElementToBeClickable("(//a[@class=\"select2-choice\"])[4]");
		click("(//a[@class=\"select2-choice\"])[4]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Ranger");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Extended details
		Thread.sleep(2000);
		ExplicitWait_ElementToBeClickable("//select[@formcontrolname=\"fuelType\"]");
		selectdropdownindex("//select[@formcontrolname=\"fuelType\"]", 1);
		type("//input[@formcontrolname=\"yearOfRegistration\"]", "2020");
		type("//input[@formcontrolname=\"vehicleWidth\"]", "25.25");
		type("//input[@formcontrolname=\"vehicleLength\"]", "10.25");
		type("//input[@formcontrolname=\"vehicleHeight\"]", "5.5");
		type("//input[@formcontrolname=\"groundClearance\"]", "150");
		type("//input[@formcontrolname=\"towingCapacity\"]", "63.25");
		WebElement element1 = driver.findElement(By.xpath("//input[@formcontrolname=\"colour\"]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element1);
		 type("//input[@formcontrolname=\"colour\"]", "White");
		 type("//input[@formcontrolname=\"emission\"]", "250");
		 click("//button[@class=\"btn btn-primary no-margin\"]");
		 //Driver
		 Thread.sleep(2000);
		 click("//button[@class=\"btn btn-primary no-margin\"]");
		 //Check form
		Thread.sleep(3000);
		selectdropdownvalue("/html/body/div[3]/ng-container/app-root/app-vehicle-fs-layout/section/div[2]/div/div/div/app-vehicle-checks-form/div/div[1]/div/form/div/div/div/div/select", "1");
	    click("//button[@class=\"btn btn-primary no-margin\"]");
	    //Reminder
		int service = day+1;
		Thread.sleep(2000);
		click("(//span[@class=\"add-on date-picker-edit cursor-pointer\"])[1]");
        Thread.sleep(1000);
		ExplicitWait_ElementToBeClickable("//span[(text()='"+service+"')]");
		click("//span[(text()='"+service+"')]");
		click("//button[@class=\"btn btn-primary no-margin\"]"); 
		//Maintenance
		dclick("(//td[contains(@class,'overflow_handsontable select_icon htPlaceholder')])[1]");
		Thread.sleep(2000);
		type("//input[contains(@class,'select2-input select')]", "maintenance task one");
		Thread.sleep(1000);
		typeenter("//input[contains(@class,'select2-input select')]");
		Thread.sleep(1000);
		 click("//button[@class=\"btn btn-primary no-margin\"]");
		}
	
	@Test(priority=15)
	public void deleteVehicle()throws InterruptedException
	{
		//Add vehicle
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary btn-small button-float add-button\"]");
		Thread.sleep(2000);
		//Basic details
		type("//input[@formcontrolname=\"registrationNumber\"]", "AB25 CDE");
		type("//input[@formcontrolname=\"vin\"]", "1N6SD11S4LC427846");
		type("//input[@formcontrolname=\"vehicleName\"]", "Delete vehicle");
		//ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[2]");
		click("(//span[@class=\"select2-chosen\"])[2]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Lorry");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		ExplicitWait_ElementToBeClickable("(//span[@class=\"select2-chosen\"])[3]");
		click("(//span[@class=\"select2-chosen\"])[3]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Ford");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//a[@class=\"select2-choice\"])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		ExplicitWait_ElementToBeClickable("(//a[@class=\"select2-choice\"])[4]");
		click("(//a[@class=\"select2-choice\"])[4]");
		ExplicitWait_ElementToBeClickable("//input[@class=\"select2-input select2-focused\"]");
		type("//input[@class=\"select2-input select2-focused\"]", "Ranger");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Extended details
		Thread.sleep(2000);
		ExplicitWait_ElementToBeClickable("//select[@formcontrolname=\"fuelType\"]");
		selectdropdownindex("//select[@formcontrolname=\"fuelType\"]", 1);
		type("//input[@formcontrolname=\"yearOfRegistration\"]", "2020");
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Driver
		Thread.sleep(2000);
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Check form
		click("//button[@class=\"btn btn-primary no-margin\"]");		  
		//Reminder
		LocalDate currentDate = LocalDate.now();
		int day = currentDate.getDayOfMonth();
		int service = day+1;
		Thread.sleep(2000);
		click("(//span[@class=\"add-on date-picker-edit cursor-pointer\"])[1]");
		Thread.sleep(1000);
		ExplicitWait_ElementToBeClickable("//span[(text()='"+service+"')]");
		click("//span[(text()='"+service+"')]");
		click("//button[@class=\"btn btn-primary no-margin\"]");			 
		//Maintenance
		click("//button[@class=\"btn btn-primary no-margin\"]");
		//Search and delete
	    click("(//input[@type=\"search\"])[2]");
		Thread.sleep(2000);
		type("(//input[@type=\"search\"])[2]", "Delete vehicle");
		Thread.sleep(2000);
		click("(//a[contains(text(),'Delete')])[1]");
		type("#confirm_delete_input", "Delete");
		click("//button[@class='btn-medium btn btn-danger']");
		Thread.sleep(2000); 
	}
	
	@Test(priority=16)
	public void viewVehicle_Timeline()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("(//input[@type=\"search\"])[2]");
		type("(//input[@type=\"search\"])[2]", vehicle);
		Thread.sleep(2000);
		click("(//a[contains(text(),'View')])[1]");
		click("#recordMenuButton");
		click("#email");
		Thread.sleep(3000);
		click("//input[@class=\"select2-input select2-default\"]");
		Thread.sleep(1000);
		type("//input[@class=\"select2-input select2-focused\"]", "srimaya.suresh@commusoft.com");
		typeenter("//input[@class=\"select2-input select2-focused\"]");
		Thread.sleep(2000);
		click("//div[@class=\"float-left icon-wrapper\"]");
		click("//div[@class=\"search-container\"]");
		type("//input[@placeholder=\"Search folders and templates\"]", "Fleet timeline");
		Thread.sleep(2000);
		typeenter("//input[@placeholder=\"Search folders and templates\"]");
        Thread.sleep(2000);
		click("//a[contains(text(),'Select')]");
		Thread.sleep(2000);
		click("//button[contains(text(),'Send')]");
		Thread.sleep(3000);
		isdisplayed("//span[text()='Vehicle created']");
		System.out.println("Vehicle creation validated in timeline");
		isdisplayed("//span[text()='Vehicle check template added']");
		System.out.println("Vehicle check form validated in timeline");
		isdisplayed("//span[text()='Vehicle reminder added']");
		System.out.println("Vehicle reminder validated in timeline");
		isdisplayed("//span[text()='Vehicle maintenance added']");
		System.out.println("Vehicle maintenance validated in timeline");
		isdisplayed("//strong[text()='Email from:']");
		System.out.println("Vehicle email validated in timeline");
		 
	}
	@Test(priority=17)
	public void viewVehicle_Maintenance()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("(//input[@type=\"search\"])[2]");
		type("(//input[@type=\"search\"])[2]", vehicle);
		Thread.sleep(2000);
		click("(//a[contains(text(),'View')])[1]");
		Thread.sleep(2000);
		click("(//span[contains(text(),'Maintenance')])");
		click("(//button[contains(text(),'Add maintenance')])");
		selectdropdownvalue("//select[@formcontrolname=\"name\"]", "1");
	    click("//button[@class=\"btn btn-primary staus-save-btn\"]");
	    isdisplayed("//span[text()='Vehicle mantenance task']");
		System.out.println("Maintenance created in view vehicle");
	}
	
	@Test(priority=18)
	public void viewVehicle_attachfiles()throws InterruptedException, AWTException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("(//input[@type=\"search\"])[2]");
		type("(//input[@type=\"search\"])[2]", vehicle);
		Thread.sleep(2000);
		click("(//a[contains(text(),'View')])[1]");
		Thread.sleep(2000);
		click("(//span[contains(text(),'Files')])");
		click("//button[contains(text(),'Add new files')]");
		Thread.sleep(2000);
		click("//span[contains(text(),'click here')]");
	        
	        String filePath = "D:\\sample\\Files\\100KB.pdf";
	        StringSelection selection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	        
	        // Click on the upload area
	        WebElement dropArea = driver.findElement(By.xpath("//div[@class=\"file-overflow note-border\"]"));
	        dropArea.click();
	        
	        // Use Robot class to paste and press Enter
	        Robot robot = new Robot();
	        robot.delay(1000);  // Wait for 1 second
	        
	        // Press CTRL + V
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	        // Press Enter
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        Thread.sleep(5000);
	        click("//span[@class=\"btn btn-primary\"]");
	        Thread.sleep(2000);
	        isdisplayed("//span[text()='100KB.pdf']");
			System.out.println("File attached successfully");
		
	}
	
	//@Test(priority=17)
	public void viewVehicle_driverhistory()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("(//input[@type=\"search\"])[2]");
		type("(//input[@type=\"search\"])[2]", "SV78 J8J");
		Thread.sleep(2000);
		click("(//a[contains(text(),'View')])[1]");
		Thread.sleep(2000);
		click("(//span[contains(text(),'Driver history')])");
		isdisplayed("//div[text()='Active driver']");
		System.out.println("Driver history validated");
	}
	
	//@Test(priority=20)
	public void viewVehicle_trips()throws InterruptedException
	
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(3000);
		click("//a[contains(text(),'View vehicles')]");
		Thread.sleep(2000);
		click("(//input[@type=\"search\"])[2]");
		type("(//input[@type=\"search\"])[2]", "tn535720");
		Thread.sleep(2000);
		click("(//a[contains(text(),'View')])[1]");
		Thread.sleep(2000);
		click("(//span[contains(text(),'Trips')])");
		click("//span[@class=\"ss-calendar\"]");
		Thread.sleep(1000);
		click("(//button[@class=\"current\"])[4]");
		Thread.sleep(1000);
		ExplicitWait_ElementToBeClickable("//span[(text()='2024')]");
		click("//span[(text()='2024')]");
		ExplicitWait_ElementToBeClickable("//span[(text()='January')]");
		click("//span[(text()='January')]");
		ExplicitWait_ElementToBeClickable("(//span[contains(text(),'18')])[2]");
		click("(//span[contains(text(),'18')])[2]");
		Thread.sleep(2000);
		isdisplayed("(//b[contains(text(),'Moving')])[1]");
		isdisplayed("(//p[contains(text(),'Stopped')])[1]");
		isdisplayed("//p[contains(text(),'Spent 10h 26m ')]");
		System.out.println("Trip validated");
	}
	
	//@Test(priority=21)
	public void Livemap()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(2000);
		click("//a[contains(text(),'View live map')]");
		click("(//div[@class=\"vehicle_list_detail_sec\"])[1]");
		Thread.sleep(4000);
		isdisplayed("//span[contains(text(),'Vehicle details')]");
		System.out.println("Vehicle side panel validated");
		click("//a[@class=\"dropdown-itemdate pointer-cursor p-10\"]");
		click("(//button[@class=\"current\"])[2]");
		Thread.sleep(1000);
		ExplicitWait_ElementToBeClickable("//span[(text()='2024')]");
		click("//span[(text()='2024')]");
		ExplicitWait_ElementToBeClickable("//span[(text()='January')]");
		click("//span[(text()='January')]");
		ExplicitWait_ElementToBeClickable("(//span[contains(text(),'18')])[1]");
		click("(//span[contains(text(),'18')])[1]");
		Thread.sleep(5000);
		click("//button[@class=\"play_badge\"]");
		Thread.sleep(5000);
		isdisplayed("//div[contains(text(),'7:05')]");
		System.out.println("Live map validated.");
	}
	
	//@Test(priority=22)
	public void recent_trip()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(2000);
		click("//a[contains(text(),'View all trips')]");
		click("(//div[@class=\"vehicle_list_detail_sec\"])[1]");
		Thread.sleep(2000);
		click("//span[@class=\"add-on date-picker-edit cursor-pointer\"]");
		click("(//button[@class=\"current\"])[2]");
		Thread.sleep(1000);
		ExplicitWait_ElementToBeClickable("//span[(text()='2024')]");
		click("//span[(text()='2024')]");
		ExplicitWait_ElementToBeClickable("//span[(text()='January')]");
		click("//span[(text()='January')]");
		ExplicitWait_ElementToBeClickable("(//span[contains(text(),'18')])[1]");
		click("(//span[contains(text(),'18')])[1]");
		Thread.sleep(3000);
		isdisplayed("//span[contains(text(),'Activity')]");
		isdisplayed("(//p[contains(text(),' Stopped')])[1]");
		isdisplayed("(//p[contains(text(),' Start')])[1]");
		System.out.println("Recent trips validated.");
	}
	@Test(priority=23)
	public void reminder_list()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(2000);
		WebElement textElement = driver.findElement(By.xpath("(//div[@class=\"count_text\"])[2]"));
        String initialText = textElement.getText();
        System.out.println("Initial value: " + initialText);
        int number1 = Integer.parseInt(initialText);
        click("(//a[contains(text(),'View more')])[1]");
        Thread.sleep(1000);
        click("(//input[@class=\"checkbox-area ng-untouched ng-pristine ng-valid\"])[1]");
        Thread.sleep(3000);
        click("//button[contains(text(),'Done')]");
        Thread.sleep(3000);
        click("(//a[contains(text(),'Fleet management')])[2]");
        Thread.sleep(3000);
        WebElement textElement2 = driver.findElement(By.xpath("(//div[@class=\"count_text\"])[2]"));
        String reduceText = textElement2.getText();
        int number2 = Integer.parseInt(reduceText);
        System.out.println("Reduced value: " + reduceText);
        if (number2+1 == number1) {
            System.out.println("Validation Passed: Reminder completed successfully");
        } 
        else {
            System.out.println("Validation Failed: Reminder not completed");
        }
	}
	@Test(priority=24)
	public void maintenance_list()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(2000);
		WebElement textElement = driver.findElement(By.xpath("(//div[@class=\"count_text\"])[3]"));
        String initialText = textElement.getText();
        System.out.println("Initial value: " + initialText);
        int number1 = Integer.parseInt(initialText);
        click("(//a[contains(text(),'View more')])[2]");
        Thread.sleep(1000);
        click("(//input[@class=\"checkbox-area ng-untouched ng-pristine ng-valid\"])[1]");
        Thread.sleep(3000);
        click("//button[contains(text(),'Done')]");
        Thread.sleep(3000);
        click("(//a[contains(text(),'Fleet management')])[2]");
        Thread.sleep(3000);
        WebElement textElement2 = driver.findElement(By.xpath("(//div[@class=\"count_text\"])[3]"));
        String reduceText = textElement2.getText();
        int number2 = Integer.parseInt(reduceText);
        System.out.println("Reduced value: " + reduceText);
        if (number2+1 == number1) {
            System.out.println("Validation Passed: Maintenance completed successfully");
        } 
        else {
            System.out.println("Validation Failed: Maintenance not completed");
        }
	}
	
	@Test(priority=25)
	public void dashboard_validation()throws InterruptedException
	{
		Thread.sleep(2000);
		click("//a[@href=\"fleet_management\"]");
		Thread.sleep(2000);
		click("(//a[contains(text(),'View all')])[2]");
		isdisplayed("//h4[contains(text(),'Safe driver leaderboard (rolling 30 days)')]");
		System.out.println("Validation Safe driver leaderboard");
		Thread.sleep(2000);
		click("//span[@class=\"cursor-pointer\"]");
		isdisplayed("//strong[contains(text(),'Missed vehicle checks')]");
		System.out.println("Missed vehicle check section validated");
		isdisplayed("//div[@class=\"mileage-chart chart-container\"]");
		System.out.println("Mileage chart validated");
	}
	}

