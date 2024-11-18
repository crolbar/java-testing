package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public
class _332Test
{
    _332 o = new _332();

    @Test void test()
    {
        var res = o.findItinerary(new ArrayList<>(
          Arrays.asList(new ArrayList<>(Arrays.asList("MUC", "LHR")),
                        new ArrayList<>(Arrays.asList("JFK", "MUC")),
                        new ArrayList<>(Arrays.asList("SFO", "SJC")),
                        new ArrayList<>(Arrays.asList("LHR", "SFO")))));

        System.out.println(res);

        List<String> expect =
          new ArrayList<>(Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC"));

        assertArrayEquals(expect.toArray(), res.toArray());
    }

    @Test void test2()
    {
        var res = o.findItinerary(new ArrayList<>(
          Arrays.asList(new ArrayList<>(Arrays.asList("JFK", "SFO")),
                        new ArrayList<>(Arrays.asList("JFK", "ATL")),
                        new ArrayList<>(Arrays.asList("SFO", "ATL")),
                        new ArrayList<>(Arrays.asList("ATL", "JFK")),
                        new ArrayList<>(Arrays.asList("ATL", "SFO")))));

        System.out.println(res);

        List<String> expect = new ArrayList<>(
          Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"));

        assertArrayEquals(expect.toArray(), res.toArray());
    }

    @Test void test3()
    {
        var res = o.findItinerary(new ArrayList<>(
          Arrays.asList(new ArrayList<>(Arrays.asList("JFK", "KUL")),
                        new ArrayList<>(Arrays.asList("JFK", "NRT")),
                        new ArrayList<>(Arrays.asList("NRT", "JFK")))));

        System.out.println(res);

        List<String> expect =
          new ArrayList<>(Arrays.asList("JFK", "NRT", "JFK", "KUL"));

        assertArrayEquals(expect.toArray(), res.toArray());
    }

    @Test void test4()
    {
        var res = o.findItinerary(new ArrayList<>(
          Arrays.asList(new ArrayList<>(Arrays.asList("EZE", "AXA")),
                        new ArrayList<>(Arrays.asList("TIA", "ANU")),
                        new ArrayList<>(Arrays.asList("ANU", "JFK")),
                        new ArrayList<>(Arrays.asList("JFK", "ANU")),
                        new ArrayList<>(Arrays.asList("ANU", "EZE")),
                        new ArrayList<>(Arrays.asList("TIA", "ANU")),
                        new ArrayList<>(Arrays.asList("AXA", "TIA")),
                        new ArrayList<>(Arrays.asList("TIA", "JFK")),
                        new ArrayList<>(Arrays.asList("ANU", "TIA")),
                        new ArrayList<>(Arrays.asList("JFK", "TIA")))));

        System.out.println("actualll: " + res);

        List<String> expect = new ArrayList<>(Arrays.asList("JFK",
                                                            "ANU",
                                                            "EZE",
                                                            "AXA",
                                                            "TIA",
                                                            "ANU",
                                                            "JFK",
                                                            "TIA",
                                                            "ANU",
                                                            "TIA",
                                                            "JFK"));

        System.out.printf("expected: %s\n", expect);
        assertArrayEquals(expect.toArray(), res.toArray());
    }

    @Test void test5()
    {
        var res = o.findItinerary(new ArrayList<>(
          Arrays.asList(new ArrayList<>(Arrays.asList("EZE", "TIA")),
                        new ArrayList<>(Arrays.asList("EZE", "HBA")),
                        new ArrayList<>(Arrays.asList("AXA", "TIA")),
                        new ArrayList<>(Arrays.asList("JFK", "AXA")),
                        new ArrayList<>(Arrays.asList("ANU", "JFK")),
                        new ArrayList<>(Arrays.asList("ADL", "ANU")),
                        new ArrayList<>(Arrays.asList("TIA", "AUA")),
                        new ArrayList<>(Arrays.asList("ANU", "AUA")),
                        new ArrayList<>(Arrays.asList("ADL", "EZE")),
                        new ArrayList<>(Arrays.asList("ADL", "EZE")),
                        new ArrayList<>(Arrays.asList("EZE", "ADL")),
                        new ArrayList<>(Arrays.asList("AXA", "EZE")),
                        new ArrayList<>(Arrays.asList("AUA", "AXA")),
                        new ArrayList<>(Arrays.asList("JFK", "AXA")),
                        new ArrayList<>(Arrays.asList("AXA", "AUA")),
                        new ArrayList<>(Arrays.asList("AUA", "ADL")),
                        new ArrayList<>(Arrays.asList("ANU", "EZE")),
                        new ArrayList<>(Arrays.asList("TIA", "ADL")),
                        new ArrayList<>(Arrays.asList("EZE", "ANU")),
                        new ArrayList<>(Arrays.asList("AUA", "ANU")))));

        System.out.println("actualll: " + res);

        List<String> expect = new ArrayList<>(Arrays.asList("JFK",
                                                            "AXA",
                                                            "AUA",
                                                            "ADL",
                                                            "ANU",
                                                            "AUA",
                                                            "ANU",
                                                            "EZE",
                                                            "ADL",
                                                            "EZE",
                                                            "ANU",
                                                            "JFK",
                                                            "AXA",
                                                            "EZE",
                                                            "TIA",
                                                            "AUA",
                                                            "AXA",
                                                            "TIA",
                                                            "ADL",
                                                            "EZE",
                                                            "HBA"));

        System.out.printf("expected: %s\n", expect);
        assertArrayEquals(expect.toArray(), res.toArray());
    }
}
