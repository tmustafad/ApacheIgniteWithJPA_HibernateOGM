package com.ignite.jpa.configuration;

import static org.apache.ignite.cache.CacheAtomicityMode.TRANSACTIONAL;

import java.util.ArrayList;
import java.util.List;

import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.hibernate.ogm.datastore.ignite.IgniteConfigurationBuilder;

import com.ignite.jpa.domain.Department;

public class IgniteConfig implements IgniteConfigurationBuilder {

	public IgniteConfiguration build() {

		IgniteConfiguration config = new IgniteConfiguration();
		config.setPeerClassLoadingEnabled(true);
		config.setClientMode(false);
		TcpDiscoverySpi discoSpi = new TcpDiscoverySpi();
		TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
		List<String> addrs = new ArrayList();
		addrs.add("127.0.0.1:47500..47509");
		ipFinder.setAddresses(addrs);
		discoSpi.setIpFinder(ipFinder);
		config.setDiscoverySpi(discoSpi);
		CacheConfiguration accountCacheCfg = new CacheConfiguration().setName("DEPARTMENT")
				.setAtomicityMode(TRANSACTIONAL).setIndexedTypes(String.class, Department.class);
		config.setCacheConfiguration(accountCacheCfg);
		return config;

	}

}