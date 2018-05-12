public class SoftCoverOrderReprint extends OrderReprint {
    @Override
    public void notifyPrintHouse() {
        System.out.println("Zamówiono książki z miękką oprawą");
    }
    @Override
    public void notifyBookstore() {
        System.out.println("Zleć drukarni wydruk z miękką oprawą");
    }



}