package io.github.itamarc.mavtest;

public class App {
    public static void main(String[] args) {
        TemplateProcessor proc = new TemplateProcessor(args[0], args[1]);
        System.out.println(proc.run());
    }
}
