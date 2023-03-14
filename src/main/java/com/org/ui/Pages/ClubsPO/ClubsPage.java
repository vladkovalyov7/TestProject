package com.org.ui.Pages.ClubsPO;
//
//import com.ita.edu.speakua.ui.BasePageWithHeader;
//import io.qameta.allure.Step;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class ClubsPage extends BasePageWithHeader {
//
//
//    @FindBy(xpath = "//div[contains(@class,'ant-card ant-card-bordered card')]")
//    protected List<WebElement> cardsBody;
//
//    public ClubsPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public List<ClubCard> getCards() {
//        List<ClubCard> cards = new ArrayList<>();
//        for (WebElement cardBody : cardsBody) {
//            cards.add(new ClubCard(this.driver, cardBody));
//        }
//        return cards;
//    }
//
//    public ClubCard getCard(int id) {
//        return getCards().get(id);
//    }
//    @Step
//    public ClubCard getLastCard() {
//        int lastCard = getCards().size()-1;
//        return getCards().get(lastCard);
//    }
//
//    @Step
//    public ClubCard getCardByName(String name) {
//        for (ClubCard card : getCards()) {
//            if (Objects.equals(card.getTitleInMyProfile(), name)) {
//                return card;
//            }
//        }
//        return null;
//    }
//
//    public AdvancedSearchComponent getAdvancedSearchComponent() {
//        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver);
//        return advancedSearchComponent;
//    }
//
//}
