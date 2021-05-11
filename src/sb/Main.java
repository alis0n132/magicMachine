package sb;

public class Main {


    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(1,2,3,4);
        System.out.println(list.toString());

        list.insert(2, 99);
        list.insert(0, 100);
        System.out.println(list.toString());
        list.insert(6, 101);
        list.insert(8, 102);

    }
}


