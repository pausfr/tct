package com.lgcns.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RunManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inputWords;
		Queue<String> wordQ = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			inputWords = sc.nextLine();
			
			String [] words = inputWords.split("\\s");		
			String action = words[0];
//			System.out.println(inputWords);
//			System.out.println(words[0]);
//			System.out.println(words[1]);
			
			if ("SEND".equals(action)) {
				wordQ.add(words[1]);
			}else if("RECEIVE".equals(action)) {
				System.out.println(wordQ.peek());
			}
			System.out.println(wordQ);
		}
	}
}




//Deque<String> numberQ = new ArrayDeque <>();

//System.out.println ("Deque '" + numberQ. poll pollpoll() + "'");
//System.out.println ("Peek : " + numberQ.peek ());
//System.out.println ("Contains( \"three \") = " + numberQ.contains ("three"));
//numberQ.clear ();
//System.out.println ("Queue Count = " + numberQ.size ())