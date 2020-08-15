import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @BeforeEach
    public void openPage() {
        // Открыть сайт АльфаБанк
        open("http://alfabank.ru");

        // Нажать на ссылку "Вклады"
        $(byText("Вклады")).click();
    }

    //Занятие №3, Задание №2
    @Test
    void archiveDepositsSizeTest() {
        $(byTitle("Депозиты")).click(); //  Нажать на ссылку "Депозиты"
        $(byText("Архивные депозиты")).click(); // Нажать на ссылку "Архивные депозиты"

        // Проверить, что количество архивных депозитов равно трём
        $$(".product-cell__cell-back").shouldHave(size(3));
    }

    //Занятие №3, Задание №3

    // 01. Поиск элемента с использованием метода sibling()
    @Test
    void siblingExampleTest() {
        $(byText("Накопительные счета")).parent().sibling(4).click();
        
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 02. Поиск элемента с использованием метода preceding()
    @Test
    void precedingExampleTest() {
        $(byAttribute("href", "/make-money/44-fz/")).parent().preceding(0).click();
        
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 03. Поиск элемента с использованием метода parent()
    @Test
    void parentExampleTest() {
        $x("//*[@id=\"product_page_list\"]/div[3]/div[2]/div[1]/div/div[2]/ul/li[6]").parent().click(); // todo fix locator
        
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }

    // 04. Поиск элемента с использованием метода closest()
    @Test
    void closestExampleTest() {
        $x("//*[@id='product_page_list']/div[3]/div[2]/div[1]/div/div[2]/ul/li[6]/a").closest("li").click();  // todo fix locator
        
        $(".col-xs-offset-2").shouldHave(text("Страхование вкладов"));
    }
}
