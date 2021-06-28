package adapters;

import com.google.gson.Gson;
import constants.IUrlConstants;
import lombok.extern.log4j.Log4j2;
import objects.TestProject;
import objects.Project;

@Log4j2
public class ProjectsAdapter extends BaseAdapter implements IUrlConstants {

    /**
     * Create project.
     *
     * @param testProject the project
     * @return the project
     */
    public Project create(TestProject testProject) {
        log.info(String.format("Create project '%s'", testProject.getTitle()));
        return new Gson().fromJson(post(PROJECT_URI, converter.toJson(testProject)), Project.class);
    }
}