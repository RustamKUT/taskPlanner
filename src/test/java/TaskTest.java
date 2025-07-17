import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        Task task = new SimpleTask(1, "Доброе утро");

        boolean actual = task.matches("Доброе");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        Task task = new SimpleTask(1, "Доброе утро");

        boolean actual = task.matches("Злое");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Ложка", "Вилка", "Нож"};
        Epic epic = new Epic(20, subtasks);

        boolean actual = epic.matches("Нож");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Ложка", "Вилка", "Нож"};
        Epic epic = new Epic(20, subtasks);

        boolean actual = epic.matches("Ковшик");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingMatchesTopic() {
        Meeting meeting = new Meeting(
                30,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        boolean actual = meeting.matches("Наследование");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingMatchesProject() {
        Meeting meeting = new Meeting(
                30,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNotMatches() {
        Meeting meeting = new Meeting(
                30,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        boolean actual = meeting.matches("воскресение");

        Assertions.assertFalse(actual);
    }

}