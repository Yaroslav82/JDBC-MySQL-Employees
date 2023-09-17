package org.example.app.views;

public class ReadView implements View {

    @Override
    public void getOutput(String output) {
        System.out.println(output);
    }
}
