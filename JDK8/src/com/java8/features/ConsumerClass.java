package com.java8.features;

import java.util.function.Consumer;

public class ConsumerClass implements Consumer<Common>{

	public void accept(Common com) {
		com.setName("#"+com.getName()+"#");
	}
}
