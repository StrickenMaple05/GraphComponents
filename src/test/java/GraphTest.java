import org.junit.jupiter.api.*;

public class GraphTest {

    /**
     * Граф
     */
    private Graph graph;
    Node a,b,c,d,e,f,g;

    @BeforeEach
    public void init() {
        graph = new Graph();
        a = new Node(0);
        b = new Node(1);
        c = new Node(2);
        d = new Node(3);
        e = new Node(4);
        f = new Node(5);
        g = new Node(6);
    }

    @DisplayName("1 компонента связности")
    @Test
    public void graphTest1() {
        graph.add(a,b,c,d,e,f,g);                   //  связи ориентированы по возрастанию алфавита
        a.addLink(b,c);                             //  a - c - d  g
        b.addLink(e);                               //  |   |   | /
        c.addLink(d,e);                             //  b - e - f
        e.addLink(f);
        d.addLink(f);
        f.addLink(g);
        int count = graph.countGraphComponents();
        Assertions.assertEquals(1, count);
    }

    @DisplayName("3 компоненты связности")
    @Test
    public void graphTest2() {
        graph.add(a,b,c,d,e,f,g);                   //  связи ориентированы по возрастанию алфавита
        a.addLink(b,c);                             //  a - c - d
        b.addLink(c);                               //  | /        g
        c.addLink(d);                               //  b   e - f
        e.addLink(f);
        int count = graph.countGraphComponents();
        Assertions.assertEquals(3, count);
    }

    @DisplayName("7 компонент связности")
    @Test
    public void graphTest3() {
        graph.add(a,b,c,d,e,f,g);                   //  связи ориентированы по возрастанию алфавита
        int count = graph.countGraphComponents();   //  a   c   d   g
        Assertions.assertEquals(7, count);  //  b   e   f
    }
}
