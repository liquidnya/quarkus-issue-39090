package org.acme;

import java.util.Optional;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "my-config")
public interface MyConfig {
	GlobalConfig global();

	interface CommonConfig {
		Optional<String> commonTest();

		UserConfig user();
	}

	interface GlobalConfig extends CommonConfig {
		Optional<String> globalTest();
	}

	interface UserConfig {
		Optional<String> name();
	}
}