package com.lgcns.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RunManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inputWords;
		Queue<String> wordQ = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, LinkedList> queMap = new HashMap<>();
		HashMap<String, Integer> queSizeMap = new HashMap<>();
		
		while (true) {
			inputWords = sc.nextLine();
			
			String [] words = inputWords.split("\\s");		
			String action = words[0];
			
			String queName = words[1];
			if ("SEND".equals(action)) {
				if(queMap.get(queName).size() >= queSizeMap.get(queName)) {
					System.out.println("Queue Full");
				} else {
					String sendWord = words[2];
					queMap.get(queName).add(sendWord);
					}
			}else if("RECEIVE".equals(action)) {				
				System.out.println(queMap.get(queName).poll());
			}else if("CREATE".equals(action)) {				
				if (queMap.containsKey(queName)) {
					System.out.println("Queue Exist");
				} else {					
					String queSize = words[2];
					queMap.put(queName, new LinkedList<String>());
					queSizeMap.put(queName, Integer.parseInt(queSize));				
				}
			}
			
		}
	}

}
