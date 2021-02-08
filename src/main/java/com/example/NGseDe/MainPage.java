package com.example.NGseDe;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    /**
     * определение метода главной страницы
     */
    public MainPage open(){
        Selenide.open("/");
        return this;
    }
     /**
     * определение локатора кнопки входа в аккаунта с главной страницы
     */
    public SelenideElement toolsMenu = $("desk-notif-card__card");

    /**
     * определение локатора поля ввода поиска
     * define locator search entry field
     */
    public   SelenideElement searchlocation = $(By.id("text"));///
    /**
     * определение локатора кнопки ввода поиска
     * define locator button search entry field
     */

    public SelenideElement SearchBtn = $(By.className("search2__button"));
    /**
     * определение локатора результата поиска
     *
     */

   public SelenideElement searchresult = $(By.className("organic__content-wrapper"));

    /**
     * определение локатора кнопки входа на сервис "Объявления" с главной страницы
     */

    public SelenideElement LinkAds =  $(By.linkText("Объявления"));

    /**
     * определение локатора кнопки выхода из аккаунта
     */

    public static SelenideElement logoutBtn = $(By.linkText("Выйти"));


    /**
     * определение локатора кнопки входа в аккаунт
     */

    public static SelenideElement loginBtn = $x("//button[@type='submit']");


    /**
     * определение локатора поля ввода логина
     */

    public   SelenideElement loginField = $(By.id("passp-field-login"));


    /**
     * определение локатора поля ввода пароля
     */

    public static SelenideElement passwdField = $(By.id("passp-field-passwd"));


    /**
     * определение локатора поля меню пользователя
     */


    public static SelenideElement userMenu = $(By.className("user-account__name"));

     /**
     * метод для ввода логина
     */
    public   void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * метод для ввода пароля
     */
    public static void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }


    /**
     * метод для получения имени пользователя из меню пользователя
     * method get user menu username
     */
    public static String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }
    }

