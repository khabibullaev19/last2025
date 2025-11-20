package com.saucedemo.pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage{

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By logInButton = By.id("login-button");
    private By errorMessage = By.className("error-button");

    public void setUsername(String username) {
        set(userNameField, username);
    }

    public void setPassword(String password) {
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton() {
        click(logInButton);
        return new ProductsPage();
    }

    public ProductsPage logIntoApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

}
