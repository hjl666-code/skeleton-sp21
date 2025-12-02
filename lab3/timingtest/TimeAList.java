package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> NList = new AList<>();
        AList<Double> TimeList = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int cur = 1000;
        while(cur <= 128000){
            NList.addLast(cur);
            opCounts.addLast(cur);
            cur = cur * 2;
        }
        for(int i = 0; i < NList.size(); i++){
            int N = NList.get(i);
            AList<Integer> List = new AList<>();
            Stopwatch sw = new Stopwatch();
            while((N--) != 0)List.addLast(N);
            TimeList.addLast(sw.elapsedTime());
        }
        printTimingTable(NList,TimeList,opCounts);
    }
}
