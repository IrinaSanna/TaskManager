import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TaskTest {
    @Test
    public void shouldFindWhenRequestMatches() { // запрос совпадает с задачей
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        Boolean expected = true;
        Boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenRequestNoMatches() { // совпадений по запросу нет
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Boolean expected = false;
        Boolean actual = simpleTask.matches("написать");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenEpicMatchesByRequest() { // запрос совпадает с подзадачами
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);


        Boolean expected = true;
        Boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenEpicNoMatchesByRequest() { // запрос не совпадает с подзадачами
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Boolean expected = false;
        Boolean actual = epic.matches("Сыр");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenTopicMatchesByRequest() { // есть совпадение по теме
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean expected = true;
        Boolean actual = meeting.matches("3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenTopicNoMatchesByRequest() { // нет совпадений
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean expected = false;
        Boolean actual = meeting.matches("релиз");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenProjectMatchesByRequest() { // есть совпадение по названию проекта
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean expected = true;
        Boolean actual = meeting.matches("НетоБанк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindWhenProjectNoMatchesByRequest() { // нет совпадений по названию проекта
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Boolean expected = false;
        Boolean actual = meeting.matches("банк");

        Assertions.assertEquals(expected, actual);
    }
}