// thinkinjavaex/chapter13/SplitDemo.java

import java.util.regex.*;
import java.util.*;
import static com.wyett.util.Print.*;

public class Ex14 {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		print(Arrays.toString(input.split("!!")));
		// Only do the first three:
		print(Arrays.toString(input.split("!!", 3)));
	}
}