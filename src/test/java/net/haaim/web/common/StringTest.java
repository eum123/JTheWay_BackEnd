package net.haaim.web.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;



public class StringTest {
	@Test
	public void splitTest() {
		String data = "1|2|3";
		
		String[] d = data.split("");
		Arrays.asList(d).stream().filter(x -> !x.equals("|")).forEach(x -> System.out.println(x));
		
		assertEquals("", "");
	}
}
