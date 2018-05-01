package com.java8.features;
/*package com.rakuten.test.pingpong;

import java.util.HashMap;
import java.util.Map;

public class Processor {
	
	public static void calaculate(int numberofPeople, int [][] timerange) {
		
		Map<String,Integer> output = new HashMap<>();
		
		//for (int people = 0; people < numberofPeople ; people++) {
			for (int i = 0 ; i < numberofPeople ; i++) {
				
				Integer startTime = timerange[i][0];
				Integer endTime = timerange[i][1];
				
				for (int item = startTime; item < endTime ; item ++) {
					String key = item + "";
					if (output.containsKey(key)) {
						Integer currentCount = output.get(key);
						Integer sum = currentCount.intValue() + 1;
						output.put(key,sum);
					}else {
						output.put(key, new Integer("1"));
					}
				}
				
				for (int j = 0 ; j < 2 ; j++) {
					if (j == 0) {
						Integer startTime = timerange[i][j];
						String startkey = startTime.intValue()+"";
						Integer endTime = timerange[i][j+1] - 1;
						if (output.containsKey(startkey)) {
							Integer currentCount = output.get(startkey);
							Integer sum = Math.abs(startTime.intValue() - endTime.intValue());
							currentCount.intValue();
							output.put(startkey,sum);
							continue;
						}else {
							output.put(startkey, new Integer("1"));
						}
					}else {
						Integer endTime = timerange[i][j] - 1;
						String endkey = endTime.intValue()+"";
						if (output.containsKey(endkey)) {
							Integer sum = output.get(endkey).intValue() + 1;
							output.put(endkey, sum);
						}else {
							output.put(endkey, new Integer("1"));
						}
					}
				
				}
				Integer startTime = timerange[i][i];
				Integer endTime = timerange[i][i+1];
				String startkey = startTime.intValue()+"";
				String endkey = startTime.intValue()+"";
					if (output.containsKey(startkey)) {
						Integer currentCount = output.get(startkey);
						Integer sum = (startTime.intValue() - endTime.intValue()) + currentCount.intValue();
						output.put(startkey,sum);
						continue;
					}else {
						output.put(startkey, new Integer("1"));
					}
					
					if (output.containsKey(endkey)) {
						Integer sum = output.get(endkey).intValue() + 1;
						output.put(endkey, sum);
					}else {
						output.put(endkey, new Integer("1"));
					}
				//}
			}
		//}
			
			for (Map.Entry<String, Integer> entry : output.entrySet()) {
				System.out.println("Key::" + entry.getKey() + " Value::" + entry.getValue());
			}
		
	}

}
*/