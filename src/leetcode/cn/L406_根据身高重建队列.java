package leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L406_根据身高重建队列 {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue(people);

        for (int i=0; i<people.length; ++i) {
            for (int j=0; j<people[0].length; ++j) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] reconstructQueue(int[][] people) {
        List<int[]> lists = Arrays.asList(people);
        List<int[]> result = new ArrayList<>();
        lists.sort((x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        for (int i = 0; i < lists.size(); ++i) {
            result.add(lists.get(i)[1], lists.get(i));
        }
        return result.toArray(new int[0][]);
    }
}
