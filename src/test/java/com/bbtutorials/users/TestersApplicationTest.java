package com.bbtutorials.users;

import com.bbtutorials.users.controller.TestersController;
import com.bbtutorials.users.entity.ResultTester;
import com.bbtutorials.users.entity.Tester;
import com.bbtutorials.users.entity.TesterDevice;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestersApplicationTest {

	@Test
	void contextLoads() {
	}


	@Test
	void parseBugsCSV() throws IOException {
		Bugs.bugs.clear();
		Bugs b = new Bugs();
		b.parseCSV();

		assertThat(Bugs.bugs.size()).isGreaterThan(1);
	}

	@Test
	void parseTestersCSV() throws IOException {
		Testers.testers.clear();
		Testers t = new Testers();
		t.parseCSV();

		assertThat(Testers.testers.size()).isGreaterThan(1);
	}

	@Test
	void getCountries() throws IOException {
		Testers.countries.clear();
		Testers t = new Testers();
		t.parseCSV();

		assertThat(Testers.countries.size()).isGreaterThan(1);
		assertThat(Testers.countries.contains("US"));

	}

	@Test
	void getNoTesterss() throws IOException {
		TesterDevices t = new TesterDevices();
		List<ResultTester> results = t.searchTesters(null, null);

		assertThat(results.size()).isEqualTo(0);

	}
}
