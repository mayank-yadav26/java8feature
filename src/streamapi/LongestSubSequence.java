package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Find the longest subsequence of consecutive numbers in a given list using
 * Java 8 Streams.
 * Input:
 * List<Integer> numbers = List.of(100, 4, 200, 1, 3, 2, 5, 6, 7, 8);
 * Output:
 * Longest consecutive subsequence: [1, 2, 3, 4, 5, 6, 7, 8]
 */
public class LongestSubSequence {
	public static void main(String[] args) {
		List<Integer> currSubSeq = new ArrayList<>();
		List<Integer> longSubSeq = new ArrayList<>();
		List<Integer> numbers = List.of(100, 4, 200, 1, 3, 2, 5, 6, 7, 8);
		List<Integer> sortedList = numbers.stream()
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		
		for(int num : sortedList) {
			if(currSubSeq.isEmpty() || num==currSubSeq.get(currSubSeq.size()-1)+1) {
				currSubSeq.add(num);
			}else {
				if(currSubSeq.size()>longSubSeq.size()) {
					longSubSeq = new ArrayList<>(currSubSeq);
				}
				currSubSeq.clear();
				currSubSeq.add(num);
			}
		}
		if(currSubSeq.size()>longSubSeq.size()) {
			longSubSeq = new ArrayList<>(currSubSeq);
		}
		System.out.println("Long Sub Seq : "+longSubSeq);
		
		// Another way by Map
	    // Convert the list into a map where each number is a key and the value is true.
        Map<Integer, Boolean> map = numbers.stream()
            .collect(Collectors.toMap(
                Function.identity(),   // key mapper: use the number itself as the key
                num -> true            // value mapper: assign true to each key
            ));
        
        // set false for those which are not start of sequence. If num-1 value exist in map
        // then its false(can not be start of sequence)
        numbers.stream()
        .forEach(num->{
        	if(map.containsKey(num-1)) {
        		map.put(num, false);
        	}
        });
        
        int maxLen = 0;
        int maxLenStartPoint = 0;
        for(int num : numbers) {
        	int tempLen = 0;
        	int tempSeqStart = num;
        	if(map.get(num)==true) {
        		while(map.containsKey(tempSeqStart)) {
        			tempLen++;
        			tempSeqStart++;
        		}
        		if(tempLen>maxLen) {
        			maxLen = tempLen;
        			maxLenStartPoint = num;
        		}
        	}
        };
        ArrayList<Integer> ans = new ArrayList<>();
        while(map.containsKey(maxLenStartPoint)) {
        	ans.add(maxLenStartPoint);
        	maxLenStartPoint++;
        }
        System.out.println("Long Sub Seq : "+ans);
        
		
	}
}
