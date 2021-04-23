package ru.sbrf.lesson6.hw6;

/**
 * The CircularBuffer is a class representing circular buffer data structure
 */
public class CircularBuffer {
    /**
     * class representing Circular buffer node
     * (essentially it is a linked list node)
     */
    private class CBNode {
        Integer value;
        CBNode next;
        CBNode(Integer value, CBNode next) {
            this.value = value;
            this.next = next;
        }
        CBNode(Integer value) {  this(value, null);  }
        CBNode() {  this(null, null);  }
    }

    private Integer capacity = 4;
    CBNode start;
    CBNode end;

    public CircularBuffer() {
        start = new CBNode();
        end = start;
        for (int i = 0; i < capacity-1; i++) {
            end.next = new CBNode();
            end = end.next;
        }
        end.next = start;
        end = start;
    }

    public boolean QueueEmpty() {
        return (start.value == null);
    }

    /**
     * Insert value at the "end" of the buffer. "End" of the buffer remains
     * on inserted value (such way allows to avoid premature buffer doubling).
     * If needed - it is repositioned to the next element.
     * If the next element is "start" - buffer size gets doubled.
     *
     * @param  value   value to insert
     */
    public void Enqueue(Integer value) {
        if (end.value != null) {
            if (end.next.equals(start)) {
                doubleBufferSize();
            }
            end = end.next;
        }

        end.value = value;
    }

    /**
     * Pop an element from the "start" of the CircularBuffer and
     * shift "start" to the next node.
     * If "start" and "end" were on the same node then end gets shifted too.
     *
     */
    public Integer Dequeue() {
        Integer el = start.value;
        start.value = null;

        if(start.equals(end))
            end = start.next;

        start = start.next;

        return el;
    }

    /**
     * Double buffer size by inserting empty nodes between "end" and "start"
     */
    private void doubleBufferSize() {
        CBNode tmp = end;
        for (int i = 0; i < capacity; i++) {
            tmp.next = new CBNode();
            tmp = tmp.next;
        }
        tmp.next = start;
        capacity *= 2;
    }

    /**
     * Handle user commands.
     *
     * @param  command   command inserted by user
     */
    public void handleUserCommand(String command) {
        String[] commandArray = command.split(" ");

        switch (commandArray[0]) {
            case "EMPTY":
                System.out.println(QueueEmpty());
                break;
            case "ENQ":
                Enqueue(Integer.parseInt(commandArray[1]));
                break;
            case "DEQ":
                System.out.println(Dequeue());
                break;
            case "STATE":
                printBufferState();
                break;
        }
    }

    /**
     * JUST FOR TESTING
     * Prints the state of all nodes from "start".
     * Also labels current "start" and "end"
     *
     */
    public void printBufferState() {
        System.out.println("Current buffer state:");
        int i = 0;
        for (var node = start; i < capacity; i++, node = node.next) {
            System.out.print(node.value + " ");
            if (node.equals(start))
                System.out.print("<-(start) ");
            if (node.equals(end))
                System.out.print("<-(end) ");
        }
        System.out.println("");
    }
}
