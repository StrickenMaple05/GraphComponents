import java.util.*;

/**
 * Класс "граф"
 */
public class Graph {

    /**
     * Список узлов графа
     */
    private List<Node> nodes = new ArrayList<>();

    public Graph(Node... nodes) {
        this.nodes.addAll(Arrays.asList(nodes));
    }

    public void add(Node... nodes) {
        this.nodes.addAll(Arrays.asList(nodes));
    }

    /**
     * Подсчёт компонент связности графа. Основан на обходе в глубину
     * @return количество компонент связности
     */
    public int countGraphComponents() {
        int count = 0;
        for (Node node : nodes) {
            if (node.isVisited()) {
                continue;
            }
            ++count;
            dfs(node);
        }
        return count;
    }

    /**
     * ДФС (обход в глубину)
     * @param node корень
     */
    public void dfs(Node node) {
        node.setVisited(true);
        for (Node cur_node : node.getLinks()) {
            dfs(cur_node);
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
