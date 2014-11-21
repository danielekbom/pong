package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
// Entities
	TestPlayer.class,
	TestBall.class,
	TestBar.class
})
public class AllTests {
	
}