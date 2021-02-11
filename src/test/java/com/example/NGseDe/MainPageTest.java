package com.example.NGseDe;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;


public class MainPageTest {
    //protected static MainPage mainPage;
    MainPage mainPage = new MainPage();
    @BeforeClass

    public static void setUpAllure() {
        Configuration.baseUrl = (ConfProperties.getProperty("LoginPage"));
        Configuration.startMaximized = true;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }





        @Test(priority = 1, enabled = true)
    public void InputLogin() {
            /**
             * open page authorization
             * define login input field -visible
             * using method inputLogin
             * enter button
             * enter password use method inputPasswd
             * click button
             * wait visibl locator "usermenu"
             *  method get user menu username
     \        *  cheсk name = username
             */
        open("/");

        mainPage.loginField.shouldBe(visible);
        mainPage.inputLogin(ConfProperties.getProperty("login"));
        mainPage.loginBtn.click();
        mainPage.inputPasswd(ConfProperties.getProperty("password"));
        mainPage.loginBtn.click();
        mainPage.userMenu.shouldBe(visible).click();
        String user = mainPage.getUserName();
        assertEquals(ConfProperties.getProperty("Name"), user);
        mainPage.logoutBtn.click();
    }

    @Test(priority = 2, enabled = true)
    public void SearchMain() {
        /**
         * open  search page
         * define locate input text and hover the cursor mause
         * clear search field
         * enter  text "apple"
         * chek search result
         */

        open(ConfProperties.getProperty("LoginPage1"));
        mainPage.searchlocation.click();
        mainPage.searchlocation.clear();
        mainPage.searchlocation.sendKeys("apple");
        mainPage.SearchBtn.click();
        mainPage.searchresult.shouldHave(text("Apple"));


    }
    @Test(priority = 3, enabled = true)
    public void LinkAds(){
        /**
         * open page main page yandex.ru
         * click link "Объявления"
         * chek title page "Объявления"
         */
        open(ConfProperties.getProperty("LoginPage1"));
        mainPage.LinkAds.click();
        String AdsTitle = Selenide.title();
        assertEquals((AdsTitle),( "Объявления"));

    }


}



