package com.github.disc99.template.engine;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TemplateTest {

    @Test
    public void testRender() throws IOException {

        Bean bean = new Bean();
        String actual = new Template("Hello {{name}} {{# subs}}{{num}} {{/}}for Test").render(bean);

        assertThat(actual, is("Hello Tom 1 2 3 for Test"));
    }
    
    public class Bean {
    	private String name = "Tom";
    	private List<Sub> subs = Arrays.asList(new Sub(1), new Sub(2), new Sub(3));

		public String getName() {
			return name;
		}
		public List<Sub> getSubs() {
			return subs;
		}
    }
    
    public class Sub {
    	private int num;
    	public Sub(int num) {
    		this.num = num;
    	}
    	public int getNum() {
    		return num;
    	}
    }
}
