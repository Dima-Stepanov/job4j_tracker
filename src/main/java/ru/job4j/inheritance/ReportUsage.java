package ru.job4j.inheritance;

/**
 * 1.2.2.Наследование
 * 4.Переопределение[#174890#127059]
 */
public class ReportUsage {
    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        String text = textReport.generate("Report's name",
                "Report's body");
        System.out.println(text);

        HtmlReport htmlReport = new HtmlReport();
        String html = htmlReport.generate("Report's name",
                "Report's body");
        System.out.println(html);

        JSONReport jsonReport = new JSONReport();
        String json = jsonReport.generate("Report's name",
                "Report's body");
        System.out.println(json);
    }
}
