package tests;

import adapters.BaseAdapter;
import adapters.ProjectsAdapter;
import adapters.SuiteAdapter;
import objects.TestProject;
import objects.TestSuite;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners(TestListener.class)
public class QaseTest {

    /**
     * Gets all projects test.
     */
    @Test(description = "Get all projects")
    public void getAllProjectsTest() {
        new BaseAdapter().get("project");
    }

    /**
     * Create project test.
     * This method check created project code
     */
    @Test(description = "Check created project code")
    public void createTestProjectTest() {
        TestProject testProject = TestProject.builder()
            .title("QA05AHTEST")
            .code("QAAHTEST")
            .description("AH Test project")
            .access("all")
            .group(null)
            .build();
        String createProjectCode = new ProjectsAdapter().create(testProject).getResult().getCode();
        Assert.assertEquals(createProjectCode, "QAAHTEST");
    }

    /**
     * Create new test suite test.
     * This method check created test suite status
     */
    @Test(description = "Check created test suite status")
    public void createNewTestSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
            .title("Test suite")
            .parentId(null)
            .description("Suite description")
            .preconditions("Preconditions")
            .build();
        boolean createdTestSuiteStatus = new SuiteAdapter().create("QAAHTEST", testSuite).isStatus();
        Assert.assertTrue(createdTestSuiteStatus);
    }

    /**
     * Create new suite and delete test.
     * This method check test suite is deleted
     */
    @Test(description = "Check test suite is deleted")
    public void createNewSuiteAndDeleteTest() {
        TestSuite testSuite = TestSuite.builder()
            .title("Test suite5")
            .parentId(null)
            .description("Suite description")
            .preconditions("Preconditions")
            .build();
        int createdTestSuiteId = new SuiteAdapter().create("QAAHTEST", testSuite).getResult().getId();
        boolean actualDeletedSuiteStatus = new SuiteAdapter().delete("QAAHTEST", createdTestSuiteId).isStatus();
        Assert.assertTrue(actualDeletedSuiteStatus);
    }
}