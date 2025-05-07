package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class AbstractComponents {
    WebDriver remoteDriver;
    WebDriverWait webDriverWait;

    public AbstractComponents(WebDriver driver) {
        this.remoteDriver = driver;
        this.webDriverWait = new WebDriverWait(remoteDriver, Duration.ofSeconds(5));
    }

    public String timeStamp() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(timestamp);
    }
}