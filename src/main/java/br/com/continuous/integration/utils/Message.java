package br.com.continuous.integration.utils;

import java.util.HashMap;
import java.util.Map;

public class Message<T> {
	private  Map<String, String> atributeMessage = new HashMap<String, String>();

	private T data;
	
	public void AddField(String name, String value) {

		this.atributeMessage.put(name,value);
	}

	public Map<String, String> getAtributeMessage() {
		return atributeMessage;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
