import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTester {

    @BeforeEach
    public void openPage() {
        // Открыть сайт АльфаБанк
        open("http://alfabank.ru");

        // Нажать на ссылку "Вклады"
        $(byText("Вклады")).doubleClick();
    }

    //Занятие №3, Задание №2

    @Test
    void archiveDepositsShouldBeThree() {

        //  Нажать на ссылку "Депозиты"
        $x("//*[@id=\"product_page_list\"]/div[3]/div[2]/div[1]/div/div[2]/ul/li[2]").click();

        // Нажать на ссылку "Архивные депозиты"
        $(byText("Архивные депозиты")).click();

        // Проверить, что количество архивных депозитов равно трём
        $$(".product-cell__cell-back").shouldHave(size(3));
    }

    //Занятие №3, Задание №3

    // 01. Поиск элемента с использованием метода sibling()
    @Test
    void siblingExample() {
        $x("//*[@id=\"product_page_list\"]/div[3]/div[2]/div[1]/div/div[2]/ul/li[1]").sibling(4).click();
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 02. Поиск элемента с использованием метода preceding()
    @Test
    void precedingExample() {
        $(byAttribute("href", "/make-money/44-fz/")).parent().preceding(0).click();
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 03. Поиск элемента с использованием метода parent()
    @Test
    void parentExample() {
        $x("//*[@id=\"product_page_list\"]/div[3]/div[2]/div[1]/div/div[2]/ul/li[6]").parent().click();
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 04. Поиск элемента с использованием метода closest()
    @Test
    void closestExample() {
        $x("//*[@id='product_page_list']/div[3]/div[2]/div[1]/div/div[2]/ul/li[6]/a").closest("li").click();
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }
}
