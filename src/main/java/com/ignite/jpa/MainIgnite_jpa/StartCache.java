package com.ignite.jpa.MainIgnite_jpa;

import java.io.IOException;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

public class StartCache {
	public static void main(String[] args) {
		try {
			Ignite ignite = Ignition.start("configs/cache-node-config.xml");
			System.out.println("Presse ENTER to exit!");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
