package adapters;

import com.google.gson.Gson;
import constants.IUrlConstants;
import lombok.extern.log4j.Log4j2;
import objects.Suite;
import objects.TestSuite;

@Log4j2
public class SuiteAdapter extends BaseAdapter implements IUrlConstants {

    /**
     * Create suite.
     *
     * @param projectCode the project code
     * @param testSuite   the test suite
     * @return the suite
     */
    public Suite create(String projectCode, TestSuite testSuite) {
        log.info(String.format("Create suite '%s'", testSuite.getTitle()));
        return new Gson().fromJson(post(SUITE_URI + projectCode, converter.toJson(testSuite)), Suite.class);
    }

    /**
     * Delete suite.
     *
     * @param projectCode the project code
     * @param testSuiteId the test suite id
     * @return the suite
     */
    public Suite delete(String projectCode, int testSuiteId) {
        log.info(String.format("Delete suite with id: %s", testSuiteId));
        return new Gson().fromJson(delete(SUITE_URI + projectCode + "/" + testSuiteId), Suite.class);
    }
}