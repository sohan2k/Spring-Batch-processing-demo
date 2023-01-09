package io.sohan.Springbatchdemo.config;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class MyCustomWriter implements ItemWriter<String> {
    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String s:list){
            System.out.println("MyCustomWriter    : Writing data    : " + s);
        }
        System.out.println("MyCustomWriter    : Writing data    : completed");
    }
}
