import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Добро пожаловать");

        String[] subtasks = {"Ложка", "Вилка", "Нож"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFewTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Взять Нож");

        String[] subtasks = {"Ложка", "Вилка", "Нож"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic };
        Task[] actual = todos.search("Нож");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenZeroTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Взять Нож");

        String[] subtasks = {"Ложка", "Вилка", "Нож"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { };
        Task[] actual = todos.search("Искать");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenOneTasksFound() {
        SimpleTask simpleTask = new SimpleTask(5, "Взять Нож");

        String[] subtasks = {"Ложка", "Вилка", "Нож"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Наследование и расширяемость систем. Проблемы наследования",
                "Приложение Нетологии",
                "В понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { meeting };
        Task[] actual = todos.search("Приложение");
        Assertions.assertArrayEquals(expected, actual);
    }

}