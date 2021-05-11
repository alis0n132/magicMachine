package sb;

public class MyList<T> {

    Node<T> head;

    MyList(T... list) {

        for (T data : list) {
            addLast(data);
        }
    }

    void addLast(T data) {
        Node<T> temporaryToLast = head;

        if (head != null) {
            while (temporaryToLast.next != null) {
                temporaryToLast = temporaryToLast.next;
            }
            temporaryToLast.next = new Node<T>(data);
        } else {
            head = new Node<T>(data);
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> current = head;


        while (current != null) {
            result.append(current.value).append(" ");
            current = current.next;
        }

        return result.toString();
    }

    void insert(int index, T data){

        Node<T> currentNode = head;
        int tempIndex = 0;
        if(index < 0){
            throw new IllegalArgumentException();
        }

        if(index == 0){
            Node<T> temp = new Node<>(data);
            temp.next = head;
            head = temp;

        }


        while(tempIndex < index){

            if(currentNode == null){
                throw new IllegalArgumentException(String.valueOf(index));
            }

            if(tempIndex == index - 1){
                insertNode(data, currentNode);
                break;
            }
            currentNode = currentNode.next;
            tempIndex += 1;
        }


    }

    private void insertNode(T data, Node<T> currentNode) {
        Node<T> temp = new Node<>(data);
        temp.next = currentNode.next;
        currentNode.next = temp;
    }


}
