package io.sohan.Springbatchdemo.config;

import org.springframework.batch.item.ItemProcessor;

public class MyCustomProcessor implements ItemProcessor<String,String> {
    @Override
    public String process(String s) throws Exception {
        System.out.println("MyCustomProcessor : Processing data : "+s);
        s=s.toUpperCase();
        return s;
    }
}
