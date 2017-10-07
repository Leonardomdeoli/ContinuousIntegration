package br.com.continuous.integration.utils;

public interface ServicePath {
	public static final String ALL = "/**";
	
	public static final String ROOT_PATH = "/api";
	
	public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";

	public static final String public_ROOT_PATH = ROOT_PATH + "/public";
	
	public static final String USER_PATH = public_ROOT_PATH + "/user";
	
	public static final String PET_PATH = public_ROOT_PATH + "/pet";
}
