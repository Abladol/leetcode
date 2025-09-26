package _08_backtracking_algorithm.programmercal;

import java.util.*;

/**
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 * <p>
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 * <p>
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 */
//todo：未完成
public class _17_FindItinerary {
    private List<String> result = new ArrayList<>();

    private List<String> temp = new ArrayList<>();

    private int size;

    public List<String> findItinerary(List<List<String>> tickets) {
        List<List<String>> ticketsList = tickets.stream().sorted(Comparator.comparing(x -> x.get(1))).toList();
        temp.add("JFK");
        size = tickets.size() + 1;
        backTrace(ticketsList);


        return null;

    }

    public boolean backTrace(List<List<String>> ticketList) {
        if (temp.size() == size) {
            result = new ArrayList<>(temp);
            return true;
        }
        for (int i = 0; i < ticketList.size(); i++) {


        }
return false;

    }

    public static void main(String[] args) {
        _17_FindItinerary findItinerary = new _17_FindItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("MUC", "LHR"));
        tickets.add(List.of("JFK", "MUC"));
        tickets.add(List.of("SFO", "SFC"));
        tickets.add(List.of("LHR", "AFA"));
        findItinerary.findItinerary(tickets);
    }

}
