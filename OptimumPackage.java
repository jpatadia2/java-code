import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Figure out the optimum times from the segment list, so we can do the least amount of visits and still cover all segments */
public class OptimumPackage {

    public static void main(String[] args) {

        List<Segment> segList = new ArrayList<>();
        segList.add(new Segment(4, 7));
        segList.add(new Segment(5, 6));
        segList.add(new Segment(1, 3));
        segList.add(new Segment(2, 5));
        segList.add(new Segment(3, 4));
        System.out.println("Optimum Time(s): " + Arrays.toString(optimalPoints(segList)));
    }

    // find the maximum points in a segment so you can touch the most segments
    private static Integer[] optimalPoints(List<Segment> segList) {
        System.out.println("ORIGINAL LIST:");     segList.forEach(System.out::println);
        Collections.sort(segList);
        System.out.println("SORTED LIST:");       segList.forEach(System.out::println);

        List<Integer> optimum = new ArrayList<>();
        Integer curr = 0;
        for(int i=0; i<segList.size(); i++) {
            Segment s = segList.get(i);
            if(optimum.isEmpty()) {
                curr = s.end;
                optimum.add( curr );
                continue;
            }

            Segment last = segList.get(i-1);

            if(curr >= last.start && curr <= s.end) {
                // current fits in the last range. nothing to do
                continue;
            } else {
                if(curr < s.end) {
                    curr = s.end;
                } else {
                    optimum.remove(optimum.get(optimum.size()-1));     // remove last
                    curr = s.end;
                }
                optimum.add(curr);
            }


        }

        return optimum.toArray(new Integer[optimum.size()]);
    }

    private static class Segment implements Comparable<Segment> {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment segment) {
            return this.start - segment.start;
        }

        public String toString() {
            return "Start:"+start+", end:"+end;
        }
    }

}
