package runner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		features = {"src/test/java/stories/step16.feature","src/test/java/stories/step17.feature",
				"src/test/java/stories/step18.feature"},
		glue= {"steps","hooks"},
		dryRun = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		plugin= {"pretty","html:HTMLReports","json:JsonReports/jsonReport.json"},
		tags = "@sanity or @smoke or @regression"
		)
public class AssessmentRunner extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    /*"src/test/java/stories/step16.feature","src/test/java/stories/step17.feature",
	"src/test/java/stories/step18.feature"*/
}
 