public class HardCoverOrderReprint extends OrderReprint {


    @Override
    public void notifyPrintHouse() {
        System.out.println("Zamówiono książki z twardą oprawą");
    }

    @Override
    public void notifyBookstore() {
        System.out.println("Zleć drukarni wydruk z twardą oprawą");
    }
}
