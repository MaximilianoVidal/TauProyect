import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTest  extends BaseTests {
    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(),"Caption not displayed");
        assertEquals(caption.getTittle(),"name: user1","Caption tittle incorrect");
        assertEquals(caption.getLinkText(),"View profile","Caption link Text incorrect");
        assertTrue(caption.getLink().endsWith("/user/1"),"link text incorrect");

    }
}
