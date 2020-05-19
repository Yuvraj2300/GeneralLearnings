package com.abst;

public class WordCount {
	public static void main(String[] args) {
		String ip = "The school fair is right around the corner, and tickets have just gone on sale. Even though you may be busy, you will still want to reserve just one day out of an entire year to relax and have fun with us. Even if you don’t have much money, you don’t have to worry. The school fair is a community event, and therefore prices are kept low. Perhaps, you are still not convinced. Maybe you feel you are too old for fairs, or you just don’t like them. Well, that’s what my grandfather thought, but he came to last year’s school fair and had this to say about it: “I had the best time of my life!” While it’s true you may be able to think of a reason not to come, I’m also sure you can think of several reasons why you must come.  We look forward to seeing you at the school fair!";
		String ip2 = "Sunset! is. the time of day when our sky meets the outer space solar winds There are blue, pink, and purple swirls, \"spinning\" and twisting, like clouds of balloons caught in a blender. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that still must be done. There is a coolness, a calmness, when the sun's does set.";
		String ip3	=	"The Blue Whales just played their first baseball game of the new season; I believe there is much to be excited about. Although they lost, it was against an excellent team that had won the championship last year. The Blue Whales fell behind early but showed excellent teamwork and came back to tie the game. The team had 15 hits and scored 8 runs. That’s excellent! Unfortunately, they had 5 fielding errors, which kept the other team in the lead the entire game. The game ended with the umpire making a bad call, and if the call had gone the other way, the Blue Whales might have actually won the game. It wasn’t a victory, but I say the Blue Whales look like they have a shot at the championship, especially if they continue to improve.";
		
		String ip4	=	"Wrong answer!! , Try again!";
		String ip5	=	"It was July 21, 1969, and Neil Armstrong awoke with a start. It was the day he would become the first human being to ever walk on the moon. The journey had begun several days earlier, when on July 16th, the Apollo 11 launched from Earth headed into outer space. On board with Neil Armstrong were Michael Collins and Buzz Aldrin. The crew landed on the moon in the Sea of Tranquility a day before the actual walk. Upon Neil’s first step onto the moon’s surface, he declared, “That’s one small step for man, one giant leap for mankind.” It sure was!";
		//instring.replaceAll("[^a-zA-Z ]", "").toLowerCase()
	//	String[] words = ip5.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
		//String newip	=	ip.replaceAll("[^\w]","").
	//	System.out.println(words.length);
//		for(String w:words) {
//			System.out.println(w);
//		}
//		
		String sentip1	=	"Will education be provided by Artificial Intelligence? In my opinion, not any time soon. At least for the near future, I think human teachers will continue to be the best way to teach human students! However, I think we can absolutely expect AI to be an important tool to enhance and augment teaching. We’re on the cusp of seeing new tools emerge which will draw from Artificial Intelligence and neurotechnology to provide truly personalized learning, tailored to each students’ passions, capabilities and unique ways of thinking. When the technology can learn about and respond to our thoughts as we learn, we’ll arrive at more efficient and optimized ways of passing on knowledge.";
		String sentip2	=	"How often do you find yourself using an interrogation point in your everyday writing? What about an eroteme? You might be surprised to know that both of these appeared in the last two sentences. These terms might be unfamiliar, but you may know this punctuation mark by its more common name: the question mark. The question mark has a very simple function in writing—it indicates a question. If a sentence ends with a question mark, then it is asking a question, just as the name suggests.";
//		int sentCount	=	countSent(sentip2);
//		System.out.println("no of sent in ip were : - "+sentCount);
//		
	
		String vip	=	"Sunset is the time of day when our sky meets the outer space solar winds. There are blue, pink, and purple swirls, spinning and twisting, like clouds of balloons caught in a blender. The sun moves slowly to hide behind the line of horizon, while the moon races to take its place in prominence atop the night sky. People slow to a crawl, entranced, fully forgetting the deeds that still must be done. There is a coolness, a calmness, when the sun does set.";
		countVowels(vip);
		
		
//		int c = countWords(newip);
//		System.out.println(c);

	}

	private	static void countVowels(String ip) {
		System.out.println("Solving stage four");
		System.out.println();
		System.out.println("ip's lt: " + ip.length());

		
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		
		for(int ind=0;ind<ip.length();ind++) {
			if (ip.charAt(ind) == 'a') {
				a++;
			} else if (ip.charAt(ind) == 'e') {
				e++;
			} else if (ip.charAt(ind) == 'i') {
				i++;
			} else if (ip.charAt(ind) == 'o') {
				o++;
			} else if (ip.charAt(ind) == 'u') {
				u++;
			}
		}
		
		System.out.println("a : "+a);
		System.out.println("e : "+e);
		System.out.println("i : "+i);
		
		System.out.println("o : "+o);
		System.out.println("u : "+u);
		
	}
	
	
	private static int countWords(String s) {
	int wordCount = 0;

		boolean word = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			// if the char is a letter, word = true.
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				wordCount++;
				word = false;
				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;
/*
		int countWord = 0;
	    String[] words = s.split("\\s+");
	    for (String word : words) {
	        if (!word.matches("\\p{Punct}+")) {
	            countWord++;
	        }
	    }
	    System.out.println("Total number of words: " + countWord);
	    return countWord;
*/
	}
	
	
	private	static int countSent(String ip) {
	final String SENTENCE_DELIMS	=	".?!";
		
		System.out.println("Solving stage three");
		System.out.println();
		System.out.println("ip's lt: " + ip.length());

		int sentCount	=	0;
		int lastIndex=0; 	
			
		for(int i=0;i<ip.length();i++) {
			 for(int j=0;j<SENTENCE_DELIMS.length();j++){  
				 if(ip.charAt(i)==SENTENCE_DELIMS.charAt(j)) {
					 if(lastIndex!=i-1) {
						 sentCount++;
					 }
					 lastIndex=i;
				 }
			 }	
		}
		return sentCount;
		
	}
	
}
