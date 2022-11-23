package io.sohan.Springbatchdemo.config;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyCustomReader implements ItemReader<String> {

    private String[] strArray={"Zero", "One", "Two", "Three", "Four", "Five"};

    private int indx=0;
    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(indx>strArray.length || indx==5){
            return null;
        }
        String data=indx + " " + strArray[indx];
        indx++;
        return data;
    }
}
