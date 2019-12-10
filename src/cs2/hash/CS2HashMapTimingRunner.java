package cs2.hash;

public class CS2HashMapTimingRunner {
    public static void main(String[] args) {
        int n = 10000;
        System.out.println("size\tput\tget");
        for (int i = 1; i < 2*n+1; i++) {
            CS2HashMap<Double, Double> map = new CS2HashMap<>(i);
            long pStart = System.nanoTime();
            for (int j = 0; j < n; j++) {
                map.put(Math.random(), 19.19);
            }
            long pEnd = System.nanoTime(); long pTime = pEnd - pStart; long pAvgTime = pTime/n;
            long gStart = System.nanoTime();
            for (Double key: map.keySet()) {
                map.get(key);
            }
            long gEnd = System.nanoTime(); long gTime = gEnd - gStart; long gAvgTime = gTime/n;

            System.out.println(i+"\t"+pAvgTime+"\t"+gAvgTime);
        }
    }
}
