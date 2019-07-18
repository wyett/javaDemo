// thinkinjava/chapter13/Ex10.java
// TIJ4 Chapter Strings, Exercise 10, page 533
/* For the phrase "Java now has regular expressions" evaluate whether the following
* expressions will find a match:
* 	^Java		
* 	\Berg.*
*	n.w\s+h(a|i)s
*	S?
*	S+
*	s{4}
*	s{1}.
* 	s{0,3}
*/ 
// Use args: "Java now has regular expressions", "^Java", "\Berg.*", "n.w\s+h(a|i)s",
//	"s?", "s+", "s{4}", "s{1}.", "s{0,3}"
import java.util.regex.*;
import static com.wyett.util.Print.*;

public class Ex10 {
	public static void main(String[] args) {
		if(args.length < 2) {
			print("Usage:\njava TestRegularExpression " + 
				"characterSequence regularExpression+");
			System.exit(0);  
		}
		print("Input: \"" + args[0] + "\"");
		for(String arg : args) {
			print("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			if(!m.find()) 
			  	print("No match found for " + "\"" + arg + "\"");
			m.reset();
			while(m.find()) {
				print("Match \"" + m.group() + "\" at position " +
					m.start() + ((m.end() - m.start() < 2) ? "" :  ("-" + (m.end() - 1))));
			}
		}
	}
}

/*
java Ex10 "Java now has regular expressions" "^Java"       
java Ex10 "Java now has regular expressions" "\Breg."
java Ex10 "Java now has regular expressions" "n.w\s+h(a[i])s"
java Ex10 "Java now has regular expressions" "s?"
java Ex10 "Java now has regular expressions" "s+"
java Ex10 "Java now has regular expressions" "s{4}"
java Ex10 "Java now has regular expressions" "s{1}"
java Ex10 "Java now has regular expressions" "s{0,3}"


Input: "^Java"
Regular expression: "^Java"
No match found for "^Java"
Regular expression: "\Breg."
No match found for "\Breg."
Regular expression: "n.w\s+h(a[i])s"
No match found for "n.w\s+h(a[i])s"
Regular expression: "s?"
Match "" at position 0
Match "" at position 1
Match "" at position 2
Match "" at position 3
Match "" at position 4
Match "" at position 5
Regular expression: "s+"
No match found for "s+"
Regular expression: "s{4}"
No match found for "s{4}"
Regular expression: "s{1}"
No match found for "s{1}"
Regular expression: "s{0,3}"
Match "" at position 0
Match "" at position 1
Match "" at position 2
Match "" at position 3
Match "" at position 4
Match "" at position 5
*/
