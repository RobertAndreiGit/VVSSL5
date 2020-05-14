package L05_17.features.search;

import net.thucydides.core.pages.PageObject;

public class LoginPageManager extends PageObject {
    public void login(String user, String pass){
        $("#login_input").type(user);
        $("#login_pass").type(pass);
        $("[name^=loginbtn]").click();
    }

    public void search(String item){
        $("#terms").type(item);
        $("#main-search-button").click();
    }

    public void clickFirstItem(){
        $(".item-title h2 a").click();
    }

    public String getItemTitle(){
       return $(".p-name").getText();
    }

    public void addToCart(){
        $("#btn_addProductToCart").click();
    }

    public String getFirstItemTitle(){
        return $(".item-title:first-of-type h2 a").getText();
    }
}
