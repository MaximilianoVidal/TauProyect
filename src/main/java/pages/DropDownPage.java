package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;


public class DropDownPage {
    private WebDriver driver;

    private By dropdown= By.id("dropdown");

    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements= findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }


}
/*
primero creamos los atributos que vamos a usar, en este caso Webdriver para localizar elementos
el id del elemento dropdown.

segundo: creamos el constructor de la clase que toma como parametro el driver para llamarlo en el test

creamos una funcion/metodo para seleccionar el elemento dropdown y dentro de este su opcion visible posteriormente
llamada en el test

creamos una lista publica de tipo String para aprehender los elementos, para esto creamos una lista
de webelements y despues de encontrar el elemento dropdown recojemos todas las opciones que contiene
y devolvemos estos elementos pasados a map, agarramos su texto y creamos una lista de estos

para encontrar el elemento dropdown creamos un metodo que devuelve via driver dicho contenido
gracias al atributo dropdown.
 */
