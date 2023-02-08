package lt.code.academy;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.*;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.IOException;

public class AllInOne {

    public void userSelection(Scanner sc, @NotNull String action) throws IOException {

        switch (action) {
            case "1" -> {
                try {
                    userInput(sc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "2" -> {
                findStudent(sc);
            }
            case "3" -> {
                printOut();
            }
            case "4" -> {
                System.out.println("Viso gero!");
            }
            default -> System.out.println("Pasirinkite reikiama meniu punkta!");
        }
    }

    private final Map<String, User> users = new HashMap<>();
    private final File file = new File("users.json");

    public void userInput(Scanner scanner) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println("Iveskite ID");
        String studentId = scanner.nextLine();
        System.out.println("Iveskite varda:");
        String name = scanner.nextLine();
        System.out.println("Iveskite pavarde:");
        String surname = scanner.nextLine();

        users.put(studentId, new User(name, surname, studentId));

        mapper.writeValue(file, users);

    }

    public void printOut() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        User readValue = mapper.readValue(file, User.class);
        String stringUser = mapper.writeValueAsString(readValue); //veikia spausdinimas!!!

        System.out.println(stringUser);

    }

    private void findStudent(@NotNull Scanner sc) throws NullPointerException {
        System.out.printf("Iveskite ID:%n");
        String id = sc.nextLine();
        User user = users.get(id);

        if (id.equals(user.studentId())) {
            System.out.printf("Toks studentas %s %s ID: %s yra registruotas %n", user.name(), user.surname(), user.studentId());

        } else
            System.out.println("Tokio studento nera - registruokites");

    }

}



