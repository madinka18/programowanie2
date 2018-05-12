public abstract class OrderReprint {
    public void orderReprint(){
        beginOrderReprint();
        notifyBookstore();
        endOrderReprint();
        notifyPrintHouse();




    }


    public abstract void notifyPrintHouse();

    public abstract void notifyBookstore();

    private void endOrderReprint() {
        System.out.println("Zakończono dodruk książki");
    }

    private void beginOrderReprint() {
        System.out.println("Rozpoczęto zlecenie dodruku książki");
    }

}
