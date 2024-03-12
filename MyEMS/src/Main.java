public class Main {

    public static void main(String[] args) {

        try {
            EmsUI uiEMS = new EmsUI();
            uiEMS.init();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
