package code4Schenker.ex2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {
    String HTML = new String("<!DOCTYPE html>" +
            "<html>" +
            "<body>" +
            "<a href=\"https://www.domain.com\">Some link</a>" +
            "<a href=\"http://domain.com/subpage\">Another link</a>" +
            "<div>" +
            "<img src=\"https://second-domain.pl/img.jpg\">" +
            "</div>" +
            "</body>" +
            "</html>");

    String correct_answer =  new String("domain.com: 2, second-domain.pl: 1");
    App app = new App();

    @Test
    public void sampleInput1() throws Exception {
        try{
            assertEquals(correct_answer, app.extract(HTML));
        }catch(Exception e){
            Assert.fail("Exception " + e);
        }
    }
}