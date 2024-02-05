package org.example.view.views.printer;

public interface ColorPrinter extends Printer{
    void colorOutput(Color color, String text);
    void colorOut(Color color, String text);

    public enum Color {
        DEFAULT("\u001B[0m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        BLUE("\u001B[34m"),
        YELLOW("\u001B[33m"),
        PURPLE("\u001B[35m"),
        CYAN("\u001B[36m"),
        ;

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
