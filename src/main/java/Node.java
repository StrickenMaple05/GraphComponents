import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Node {
    /**
     * Индекс узла, уникальная величина
     */
    private final int index;
    /**
     * Список связей узла (смежных узлов, в которые есть путь из данного)
     */
    private Set<Node> links;
    /**
     * Флажок, показывающий, был ли данный узел просмотрен во время обхода
     */
    private boolean visited = false;

    public Node(int index) {
        this.index = index;
        links = new HashSet<>();
    }

    public Node(int index, Node... nodes) {
        this.index = index;
        links = new HashSet<>();
        links.addAll(Arrays.asList(nodes));
    }

    /**
     * Добавление связи, т.е. пути в смежный узел
     * @param nodes узлы
     */
    public void addLink(Node... nodes) {
        links.addAll(Arrays.asList(nodes));
    }

    /**
     * Задание значения флажка
     * @param value значение
     */
    public void setVisited(boolean value) {
        visited = value;
    }

    /**
     * Проверка, был ли просмотрен данный узел
     * @return булевская величниа
     */
    public boolean isVisited() {
        return visited;
    }

    public int getIndex() {
        return index;
    }

    public Set<Node> getLinks() {
        return links;
    }
}
