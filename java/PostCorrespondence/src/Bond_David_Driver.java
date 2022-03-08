import java.util.*;
import java.io.*;
public class Bond_David_Driver {

    public static void main(String[] args) throws IOException {
        Node solution = new Node();
        String filename = "/Users/davidbond/Downloads/input6.txt"; //The file name
        ArrayList<Domino> dominoes = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        int FRONTIER_SIZE = Integer.parseInt(br.readLine());
        int MAX_DEPTH = Integer.parseInt(br.readLine());
        int OUTPUT_TYPE = Integer.parseInt(br.readLine());
        int DOMINO_QUANTITY = Integer.parseInt(br.readLine());

        String[] line;
        for (int i = 0; i < DOMINO_QUANTITY; i++) {
            line = br.readLine().split(" ");
            Domino newDom = new Domino(line[1], line[2], i + 1);
            dominoes.add(newDom);
        }
        int state = BFS(dominoes,FRONTIER_SIZE, OUTPUT_TYPE, MAX_DEPTH);
        if (state == 0) {
            System.out.println("There was no solution");
        }
        else if (state == 2) {
            System.out.println("No solution was found for the given constraints in BFS");
        }

//  previous input gathering

//        System.out.print("Enter the maximum size of the queue: ");
//        int frontierSize = input.nextInt();
//        System.out.print("Enter the maximum states of the state space: ");
//        int depth = input.nextInt();
//        System.out.print("Enter a '1' to print the states or a '0' to not: ");
//        int stateFlag = input.nextInt();
//        System.out.print("Enter the number of dominoes: ");
//        int numDominoes = input.nextInt();
//        System.out.print("Enter the set of dominoes in the form (bottom top)\n");
//        input.nextLine();
//        for (int i = 1; i <= numDominoes; i++) {
//            System.out.print("Enter domino " + i + ": ");
//            String dominoStr = input.nextLine();
//            Domino domino = new Domino(dominoStr.substring(0, dominoStr.indexOf(" ")), dominoStr.substring(dominoStr.indexOf(" ") + 1), i);
//            dominoes.add(domino);
//        }
//        int isSolution = BFS(dominoes, frontierSize, stateFlag, depth, solution);
    }

    public static String getDiff(String top, String bottom) {
        if (top.length() > bottom.length()) {
            return "+" + top.substring(bottom.length());
        } else if (top.length() < bottom.length()) {
            return "-" + bottom.substring(top.length());
        }
        return "";
    }

    public static int BFS(ArrayList<Domino> dominoes, int frontierSize, int stateFlag, int maxStates) {
        Queue<Node> frontier = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (Domino dom: dominoes) {
            if (dom.isValid()) {
                String difference = getDiff(dom.top, dom.bottom);
                Node newNode = null;
                if (!difference.equals("")) {
                    newNode = new Node(difference, dom);
                }
                if (newNode != null && !set.contains(newNode.difference)) {
                    frontier.add(newNode);
                    set.add(newNode.difference);
                }
            }
        }
        while (frontier.size() > 0 && frontier.size() <= frontierSize && set.size() <= maxStates) {
            Node current = frontier.remove();
            if (current.isGoalState()) {
                System.out.println(current);
                return 1;
            }
            for (Domino dom : dominoes) {
                Node child = getNextNode(current, dom);
                if (child != null && !set.contains(child.difference)) {
                    if (child.isGoalState()) {
                        System.out.println(current);
                        return 1;
                    }
                    frontier.add(child);
                    set.add(child.difference);
                }
            }
        }
        if (frontier.size() != 0) {
            return 2;
        } else {
            return 0;
        }
    }

    public static Node getNextNode(Node node, Domino dom) {
        String oldDiff = node.difference;
        List<Domino> oldList = node.dominoes;
        String newDiff = null;

        if (oldDiff.charAt(0) == '+') {
            String newTop = oldDiff.substring(1) + dom.top;
            if (newTop.equals(dom.bottom)) {
                newDiff = "";
            } else if (newTop.startsWith(dom.bottom)) { //new top is longer
                newDiff = "+" + newTop.substring(dom.bottom.length());
            } else if (dom.bottom.startsWith(newTop)) {
                newDiff = "-" + dom.bottom.substring(newTop.length());
            }
        }
        else if (oldDiff.charAt(0) == '-') {
            String newBottom = oldDiff.substring(1) + dom.bottom;
            if (newBottom.equals(dom.top)) {
                newDiff = "";
            } else if (newBottom.startsWith(dom.top)) { //new bottom is longer
                newDiff = "-" + newBottom.substring(dom.top.length());
            } else if (dom.top.startsWith(newBottom)) {
                newDiff = "+" + dom.top.substring(newBottom.length());
            }
        }
        if (newDiff != null) {
            oldList.add(dom);
            return new Node(oldList, newDiff);
        }
        return null;
    }
}
 class Node {

    public List<Domino> dominoes;
    public String difference;

    public Node(List<Domino> dominoes, String difference) {
        this.dominoes = new ArrayList<>(dominoes);
        this.difference = difference;
    }
    public Node(String difference, Domino domino) {
       this.difference = difference;
       this.dominoes = new ArrayList<>();
       this.dominoes.add(domino);
    }
    public Node() {
       this.difference = "";
       this.dominoes = new ArrayList<>();
    }
    public boolean isGoalState() {
        return difference.length() == 0 && dominoes.size() > 0;
    }
    public String toString() {
        String str = "";
        for (Domino dominoe : dominoes) {
            str = str.concat("D" + dominoe.type + ", ");
        }
        return "The Solution found through BFS is: " + str;
    }

}

class Domino {
    public String top;
    public String bottom;
    public int type;

    public Domino(String bottom, String top, int type) {
        this.top = top;
        this.bottom = bottom;
        this.type = type;
    }

    public String getTop() {
        return this.top;
    }

    public String getBottom() {
        return this.bottom;
    }

    public boolean isValid() {
        return this.top.startsWith(this.bottom) || this.bottom.startsWith(this.top);
    }
}



