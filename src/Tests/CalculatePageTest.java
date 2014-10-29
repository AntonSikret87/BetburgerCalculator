package Tests;

import Methods.CalculatePage;
import Methods.MainPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by sikret on 27.08.2014.
 */
public class CalculatePageTest extends BaseTest {

//    @Test(groups = {"good"})
//    public void VerifyFormula3_1() throws InterruptedException, IOException {
//        goHome();
//        MainPage mainPage = new MainPage();
//        mainPage.GoToCalc();
//        CalculatePage calculatePage1 = new CalculatePage();
//        wait(2000);
//        calculatePage1.OutcomeFieldValue3FirstFormula();
//        //ArrayList<String> list = calculatePage1.listOfFormula();
//        //for (int i=1; i<list.size()+1; i++){
//        //String formula = list.get(i);
//        String formula = "# 2 1-X-2";
//        assertEquals(formula, getDriver().findElement(By.cssSelector("#formula_select > option[value=\"2\"]")).getText());
//        calculatePage1.FormulaDropDown(formula);
//        String _Odd1 = calculatePage1.getProperty("OddFirstFieldValue.good");
//        String _Odd2 = calculatePage1.getProperty("OddSecondFieldValue.good");
//        String _Odd3 = calculatePage1.getProperty("OddThirdFieldValue.good");
//        calculatePage1.OddField(_Odd1, _Odd2, _Odd3);
//    }

    public CalculatePageTest GoToCalculate() throws InterruptedException, IOException {
        goHome();
        MainPage mainPage = new MainPage();
        mainPage.GoToCalc();
        wait(8000);
        return new CalculatePageTest();
    }

    public CalculatePageTest FillAllOdds() throws InterruptedException, IOException {
        CalculatePage testpage1 = new CalculatePage();
        String _Odd1 = testpage1.getProperty("OddFirstFieldValue.good");
        String _Odd2 = testpage1.getProperty("OddSecondFieldValue.good");
        String _Odd3 = testpage1.getProperty("OddThirdFieldValue.good");
        testpage1.OddField(_Odd1, _Odd2, _Odd3);
        return new CalculatePageTest();
    }

    public CalculatePageTest FillAllComission() throws InterruptedException, IOException {
        CalculatePage testpage1 = new CalculatePage();
        String _Comission1 = testpage1.getProperty("ComissionFirstFieldValue.good");
        String _Comission2 = testpage1.getProperty("ComissionSecondFieldValue.good");
        String _Comission3 = testpage1.getProperty("ComissionThirdFieldValue.good");
        testpage1.ComissionField(_Comission1, _Comission2, _Comission3);
        return new CalculatePageTest();
    }

    public CalculatePageTest FillAllRoundTo() throws InterruptedException, IOException {
        CalculatePage testpage1 = new CalculatePage();
        String _RoundTo1 = testpage1.getProperty("RoundToFirstFieldValue.good");
        String _RoundTo2 = testpage1.getProperty("RoundToSecondFieldValue.good");
        String _RoundTo3 = testpage1.getProperty("RoundToThirdFieldValue.good");
        String _RoundTo4 = testpage1.getProperty("RoundToForthFieldValue.good");
        testpage1.RoundToField(_RoundTo1, _RoundTo2, _RoundTo3, _RoundTo4);
        return new CalculatePageTest();
    }

    public CalculatePageTest FillAllStake() throws InterruptedException, IOException {
        CalculatePage testpage1 = new CalculatePage();
        String _Stake1 = testpage1.getProperty("StakeFirstFieldValue.good");
        String _Stake2 = testpage1.getProperty("StakeSecondFieldValue.good");
        String _Stake3 = testpage1.getProperty("StakeThirdFieldValue.good");
        String _Stake4 = testpage1.getProperty("StakeForthFieldValue.good");
        testpage1.StakeField(_Stake1, _Stake2, _Stake3, _Stake4);
        return new CalculatePageTest();
    }

    @Test(groups = {"good"}) //Дописать ..узнать как брать стринги не все три а только два
    public void VerifyFormula2_1Value3AllFields() throws InterruptedException, IOException {
        CalculatePageTest testPage = new CalculatePageTest();
        testPage.GoToCalculate();
        CalculatePage test = new CalculatePage();
        test.OutcomeFieldValue2FirstFormula();
        String formula = "# 1 W1 - W2";
        assertEquals(formula, getDriver().findElement(By.cssSelector("#formula_select > option[value=\"1\"]")).getText());
        test.FormulaDropDown(formula);
        String _OddW1 = test.getProperty("OddFirstFieldValue.good");
        String _OddW2 = test.getProperty("OddSecondFieldValue.good");
        test.OddW1W2(_OddW1,_OddW2);
//        String _Comission1 = test.getProperty("ComissionFirstFieldValue.good");
//        String _Comission2 = test.getProperty("ComissionSecondFieldValue.good");
//        test.ComissionField(_Comission1, _Comission2);

    }
    @Test(groups = {"good"})
    public void Outcome3Formula1Value3AllFields() throws InterruptedException, IOException {
        CalculatePageTest testPage = new CalculatePageTest();
        testPage.GoToCalculate();
        CalculatePage test = new CalculatePage();
        test.OutcomeFieldValue3FirstFormula();
        String formula = "# 2 1-X-2";
        assertEquals(formula, getDriver().findElement(By.cssSelector("#formula_select > option[value=\"2\"]")).getText());
        test.FormulaDropDown(formula);
        CalculatePageTest testPage1 = new CalculatePageTest();
        testPage1.FillAllOdds();
        CalculatePageTest testPage2 = new CalculatePageTest();
        testPage2.FillAllComission();
        CalculatePageTest testPage3 = new CalculatePageTest();
        testPage3.FillAllRoundTo();
        CalculatePageTest testPage4 = new CalculatePageTest();
        testPage4.FillAllStake();
        test.CalculateBTN();
        assertEquals("Profit Percent -2.00", getDriver().findElement(By.cssSelector("small")).getText());
        assertEquals("5.82", getDriver().findElement(By.id("revenue1")).getText());
        assertEquals("-3.00", getDriver().findElement(By.id("revenue2")).getText());
        assertEquals("-3.00", getDriver().findElement(By.id("revenue3")).getText());
    }
    @Test(groups = {"good"})
    public void Outcome3Formula2Value3AllFields() throws InterruptedException, IOException {
        CalculatePageTest testPage = new CalculatePageTest();
        testPage.GoToCalculate();
        CalculatePage test = new CalculatePage();
        test.OutcomeFieldValue3FirstFormula();
        String formula = "# 3 W1-X-2";
        assertEquals(formula, getDriver().findElement(By.cssSelector("#formula_select > option[value=\"3\"]")).getText());
        test.FormulaDropDown(formula);
        CalculatePageTest testPage1 = new CalculatePageTest();
        testPage1.FillAllOdds();
        CalculatePageTest testPage2 = new CalculatePageTest();
        testPage2.FillAllComission();
        CalculatePageTest testPage3 = new CalculatePageTest();
        testPage3.FillAllRoundTo();
        CalculatePageTest testPage4 = new CalculatePageTest();
        testPage4.FillAllStake();
        test.CalculateBTN();
        assertEquals("Profit Percent 10.53", getDriver().findElement(By.cssSelector("small")).getText());
        assertEquals("5.82", getDriver().findElement(By.id("revenue1")).getText());
        assertEquals("0.00", getDriver().findElement(By.id("revenue2")).getText());
        assertEquals("-3.00", getDriver().findElement(By.id("revenue3")).getText());
    }
    @Test(groups = {"good"})
    public void Outcome3Formula3Value3AllFields() throws InterruptedException, IOException {
        CalculatePageTest testPage = new CalculatePageTest();
        testPage.GoToCalculate();
        CalculatePage test = new CalculatePage();
        test.OutcomeFieldValue3FirstFormula();
        String formula = "# 4 AH1(0)-2X-2";
        assertEquals(formula, getDriver().findElement(By.cssSelector("#formula_select > option[value=\"4\"]")).getText());
        test.FormulaDropDown(formula);
        CalculatePageTest testPage1 = new CalculatePageTest();
        testPage1.FillAllOdds();
        CalculatePageTest testPage2 = new CalculatePageTest();
        testPage2.FillAllComission();
        CalculatePageTest testPage3 = new CalculatePageTest();
        testPage3.FillAllRoundTo();
        CalculatePageTest testPage4 = new CalculatePageTest();
        testPage4.FillAllStake();
        test.CalculateBTN();
        assertEquals("Profit Percent 47.00", getDriver().findElement(By.cssSelector("small")).getText());
        assertEquals("5.82", getDriver().findElement(By.id("revenue1")).getText());
        assertEquals("0.00", getDriver().findElement(By.id("revenue2")).getText());
        assertEquals("-3.00", getDriver().findElement(By.id("revenue3")).getText());
    }
    @Test(groups = {"good"})
    public void Outcome3Formula4Value3AllFields() throws InterruptedException, IOException {
        CalculatePageTest testPage = new CalculatePageTest();
        testPage.GoToCalculate();
        CalculatePage test = new CalculatePage();
        test.OutcomeFieldValue3FirstFormula();
        String formula = "# 4 AH1(-1)-AH2(+1.5)-2X";
        assertEquals(formula, getDriver().findElement(By.cssSelector("#formula_select > option[value=\"5\"]")).getText());
        test.FormulaDropDown(formula);
        CalculatePageTest testPage1 = new CalculatePageTest();
        testPage1.FillAllOdds();
        CalculatePageTest testPage2 = new CalculatePageTest();
        testPage2.FillAllComission();
        CalculatePageTest testPage3 = new CalculatePageTest();
        testPage3.FillAllRoundTo();
        CalculatePageTest testPage4 = new CalculatePageTest();
        testPage4.FillAllStake();
        test.CalculateBTN();
        assertEquals("Profit Percent 47.00", getDriver().findElement(By.cssSelector("small")).getText());
        assertEquals("5.82", getDriver().findElement(By.id("revenue1")).getText());
        assertEquals("0.00", getDriver().findElement(By.id("revenue2")).getText());
        assertEquals("-3.00", getDriver().findElement(By.id("revenue3")).getText());
    }
}
