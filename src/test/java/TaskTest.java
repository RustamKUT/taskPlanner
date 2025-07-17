import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        Task task = new SimpleTask(1, "Позвонить домой");

        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        Task task = new SimpleTask(1, "Позвонить домой");

        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(20, subtasks);

        boolean actual = epic.matches("Хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(20, subtasks);

        boolean actual = epic.matches("Колбаса");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingMatchesTopic() {
        Meeting meeting = new Meeting(
                30,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingMatchesProject() {
        Meeting meeting = new Meeting(
                30,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingNotMatches() {
        Meeting meeting = new Meeting(
                30,
                "Выкатка 3й версии приложения",
                "Приложение Нетобанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("среда");

        Assertions.assertFalse(actual);
    }

}