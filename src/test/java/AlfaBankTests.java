import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    //Занятие №3, Задание №2
    @Test
    void archiveDepositsSizeTest() {
        open("http://alfabank.ru");

        $(byText("Вклады")).click();
        $(byTitle("Депозиты")).click();
        $(byText("Архивные депозиты")).click();

        $$(".product-cell__cell-back").shouldHave(size(3));
    }

    //Занятие №3, Задание №3

    // 01. Поиск элемента с использованием метода sibling()
    @Test
    void siblingExampleTest() {
        open("http://alfabank.ru");

        $(byText("Вклады")).click();
        $(byText("Накопительные счета")).parent().sibling(4).click();
        
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 02. Поиск элемента с использованием метода preceding()
    @Test
    void precedingExampleTest() {
        open("http://alfabank.ru");

        $(byText("Вклады")).click();
        $(byAttribute("href", "/make-money/44-fz/")).parent().preceding(0).click();
        
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 03. Поиск элемента с использованием метода parent()
    @Test
    void parentExampleTest() {
        open("http://alfabank.ru");

        $(byText("Вклады")).click();
        $(".navigation li", 5).parent().click();
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 04. Поиск элемента с использованием метода closest()
    @Test
    void closestExampleTest() {
        open("http://alfabank.ru");

        $(byText("Вклады")).click();
        $(byText("Страхование вкладов")).closest("li").click();

        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }
}
