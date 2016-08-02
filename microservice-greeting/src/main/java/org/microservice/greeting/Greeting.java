package org.microservice.greeting;

import java.io.Serializable;

public class Greeting implements Serializable {

	private static final long serialVersionUID = 1L;
	
    private final String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
