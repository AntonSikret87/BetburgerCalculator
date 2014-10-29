package Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sikret on 27.08.2014.
 */
public class CalculatePage extends PageBase {
    public WebElement Odd1Field;
    public WebElement Odd3Field;
    public WebElement Odd2Field;
    public WebElement CopyBtn;
    public WebElement CalculateBtn;
    public WebElement OddW1Field;
    public WebElement OddW2Field;
    public WebElement FormulaDropDownField;
    public CalculatePage() throws IOException {               //використовується у всіх тестах

        super();

    }

    public void Init() {                 //використовується у всіх тестах

    }

    public void OutcomeFieldValue2FirstFormula() throws InterruptedException {
        new Select(getDriver().findElement(By.id("outcomes_count"))).selectByVisibleText("2");
    }
    public void OutcomeFieldValue3FirstFormula() throws InterruptedException {
        new Select(getDriver().findElement(By.id("outcomes_count"))).selectByVisibleText("3");
    }
    public void OddField(String _Odd1,String _Odd2, String _Odd3) throws InterruptedException {
        Odd1Field = getDriver().findElement(By.xpath(getProperty("OddFirstField.xpath")));
        Odd1Field.click();
        Odd1Field.clear();
        Odd1Field.sendKeys(_Odd1);
        Odd2Field = getDriver().findElement(By.xpath(getProperty("OddSecondField.xpath")));
        Odd2Field.click();
        Odd2Field.clear();
        Odd2Field.sendKeys(_Odd2);
        Odd3Field = getDriver().findElement(By.xpath(getProperty("OddThirdField.xpath")));
        Odd3Field.click();
        Odd3Field.clear();
        Odd3Field.sendKeys(_Odd3);
    }
    public void OddW1W2(String _OddW1,String _OddW2) throws InterruptedException {   //Field for Outcome 2 First Formula
        OddW1Field = getDriver().findElement(By.xpath(getProperty("OddW1Field.xpath")));
        OddW1Field.click();
        OddW1Field.clear();
        OddW1Field.sendKeys(_OddW1);
        OddW2Field = getDriver().findElement(By.xpath(getProperty("OddW2Field.xpath")));
        OddW2Field.click();
        OddW2Field.clear();
        OddW2Field.sendKeys(_OddW2);
    }
    public void CopyBTN() throws InterruptedException {
        CopyBtn = getDriver().findElement(By.xpath(getProperty("CopyButton.xpath")));
        CopyBtn.click();
    }
    public void CalculateBTN() throws InterruptedException {
        CalculateBtn = getDriver().findElement(By.xpath(getProperty("CalculateButton.xpath")));
        CalculateBtn.click();

    }
    public void ComissionField(String _Comission1, String _Comission2,String _Comission3) throws InterruptedException {
        Odd1Field = getDriver().findElement(By.xpath(getProperty("ComissionFirstField.xpath")));
        Odd1Field.click();
        Odd1Field.clear();
        Odd1Field.sendKeys(_Comission1);
        Odd3Field = getDriver().findElement(By.xpath(getProperty("ComissionSecondField.xpath")));
        Odd3Field.click();
        Odd3Field.clear();
        Odd3Field.sendKeys(_Comission2);
        Odd2Field = getDriver().findElement(By.xpath(getProperty("ComissionThirdField.xpath")));
        Odd2Field.click();
        Odd2Field.clear();
        Odd2Field.sendKeys(_Comission3);
    }
    public void RoundToField(String _RoundTo1,String _RoundTo2,String _RoundTo3,String _RoundTo4) throws InterruptedException {
        Odd1Field = getDriver().findElement(By.xpath(getProperty("RoundToFirstField.xpath")));
        Odd1Field.click();
        Odd1Field.clear();
        Odd1Field.sendKeys(_RoundTo1);
        Odd3Field = getDriver().findElement(By.xpath(getProperty("RoundToSecondField.xpath")));
        Odd3Field.click();
        Odd3Field.clear();
        Odd3Field.sendKeys(_RoundTo2);
        Odd2Field = getDriver().findElement(By.xpath(getProperty("RoundToThirdField.xpath")));
        Odd2Field.click();
        Odd2Field.clear();
        Odd2Field.sendKeys(_RoundTo3);
        Odd2Field = getDriver().findElement(By.xpath(getProperty("RoundToForthField.xpath")));
        Odd2Field.click();
        Odd2Field.clear();
        Odd2Field.sendKeys(_RoundTo4);
    }
    public void StakeField(String _Stake1,String _Stake2,String _Stake3,String _Stake4) throws InterruptedException {
        Odd1Field = getDriver().findElement(By.xpath(getProperty("StakeFirstField.xpath")));
        Odd1Field.click();
        Odd1Field.clear();
        Odd1Field.sendKeys(_Stake1);
        Odd3Field = getDriver().findElement(By.xpath(getProperty("StakeSecondField.xpath")));
        Odd3Field.click();
        Odd3Field.clear();
        Odd3Field.sendKeys(_Stake2);
        Odd2Field = getDriver().findElement(By.xpath(getProperty("StakeThirdField.xpath")));
        Odd2Field.click();
        Odd2Field.clear();
        Odd2Field.sendKeys(_Stake3);
        Odd2Field = getDriver().findElement(By.xpath(getProperty("StakeForthField.xpath")));
        Odd2Field.click();
        Odd2Field.clear();
        Odd2Field.sendKeys(_Stake4);
    }
    public void FormulaDropDown(String formula) throws InterruptedException {
        Select select = new Select(getDriver().findElement(By.id("formula_select")));
        select.selectByVisibleText(formula);
   }
    public ArrayList<String> listOfFormula()  {
        ArrayList<String> list = new ArrayList<String>();
        list.add("# 2 1-X-2");
        list.add("# 3 W1-X-2");
        list.add("# 4 AH1(0)-2X-2");
        list.add("# 4 AH1(-1)-AH2(+1.5)-2X");
        list.add("# 4 TO(2)-TU(2.5)-TU(1.5)");
        list.add("# 5 AH1(-0.25)-X-2");
        list.add("# 6 AH1(-0.25)-2X-2");
        list.add("# 6 TU(1.75)-TO(1.5)-TO(2.5)");
        list.add("# 7 AH1(+0.25)-X-2");
        list.add("# 8 AH1(+0.25)-2X-2");
        list.add("# 8 TO(1.75)-TU(2.5)-TU(1.5)");
        list.add("# 9 AH1(-0.25)-X-AH2(0)");
        list.add("#10 AH1(-0.25)-2X-AH2(0)");
        list.add("#10 AH1(+0.75)-2-AH2(-1)");
        list.add("#10 TU(1.75)-TO(1.5)-TO(2)");
        list.add("#11 AH1(-0.25)-X-AH2(-0.25)");
        list.add("#12 AH1(-0.25)-2X-AH2(-0.25)");
        list.add("#12 TO(2.25)-TU(2.5)-TU(1.75)");
        list.add("#13 AH1(0)-AH2(+0.25)-2");
        list.add("#13 TO(2)-TU(2.25)-TU(1.5)");
        list.add("#14 AH1(0)-2X-AH2(-0.25)");
        list.add("#14 TO(2)-TU(2.5)-TU(1.75)");
        list.add("#15 AH1(+0.25) -AH2(0)-AH2(-0.5)");
        list.add("#15 TO(1.75)-TU(2)-TU(1.5)");
        list.add("#16 1X-12-2X");
        list.add("#17 AH1(+0.25)-12-2X");
        list.add("#18 AH1(+0.25)-12-AH2(+0.25)");
        list.add("#19 AH1(0)-12-2X");
        list.add("#20 AH1(0)-12-AH2(+0.25)");
        list.add("#21 TU(2.25)-TO(1.75)-TO(2.5)");
        return list;
    }

}
