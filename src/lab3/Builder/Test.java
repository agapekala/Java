package lab3.Builder;

import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList<String> list_to = new LinkedList<>();
        list_to.add("agapekala1@wp.pl");
        try {
            EmailMessage wiadomosc = EmailMessage.builder()
                    .addFrom("agnieszkapekala0@gmail.com")
                    .addTo(list_to)
                    .addSubject("Gosia")
                    .addContent("pyszny seeeeeer")
                    .build();
            System.out.println(wiadomosc.getFrom());
            wiadomosc.getTo().forEach(System.out::println);
            wiadomosc.send();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
