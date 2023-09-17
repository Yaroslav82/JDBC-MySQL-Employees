package org.example.app.views;

public class PositionCreateView extends CreateView {

    @Override
    public String[] getData() {
        String position = getUserInput("Enter position name: ");
        return new String[]{position};
    }
}
