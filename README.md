# Minimal template engine

## How to use

```java
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
```

## Installation

1. Add Maven repository: http://disc99.github.io/maven/
2. Add dependency: com.github.disc99.template:template:${version}

Configuration example for Gradle:

```groovy
repositories {
    maven {
        url "http://disc99.github.io/maven/"
    }
}
dependencies {
    compile "com.github.disc99:template:template:${version}"
}
```

## Requirements

* JDK 8 +

## Dependencies

None
