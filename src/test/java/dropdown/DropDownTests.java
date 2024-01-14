package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
public class DropDownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        var dropDownPage= homePage.clickDropdown();

        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions= dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "incorrect number of selections");
        assertTrue(selectedOptions.contains(option),"Option not selected");
    }
    /*aqui en el test creamos el atributo option para buscarlo dentro de dropDown element
llamamos al metodo getSelectedOptions creanto una variable con la KeyWord var
hacemos un assertEquals para verificar que la lista es correcta
* */

}
