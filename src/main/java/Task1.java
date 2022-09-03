import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;

// Timofey Novik 03.09.2022
//Test scenario "Validate users"
//1. Validate that X.json contains array of users. User must have id, name and may have address
////(city, street, # of building)
//2. Validate that X.yaml contains array of users. User must have id, name and may have address
//(city, street, # of building)
//3. Validate that all users that listed in X.json are included in the list of users from X.yaml.")

public class Task1 {

    @DataProvider(name = "dp")
    public Object[][] readListDetails() throws Exception {

        //mapper foe json files
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //mapper for yaml files
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //admin_users.json
        File adminUsersFileJSON = new File("src/main/resources/admin_users.json");
        List<AdminUser> adminUserJSON = jsonMapper.readValue(adminUsersFileJSON, jsonMapper.getTypeFactory()
                .constructCollectionType(List.class, AdminUser.class));

        //admin_users.yaml
        File adminUsersFileYAML = new File("src/main/resources/admin_users.yaml");
        List<AdminUser> adminUserYAML = yamlMapper.readValue(adminUsersFileYAML, yamlMapper.getTypeFactory()
                .constructCollectionType(List.class, AdminUser.class));

        //regular_users.json
        File regularUsersFileJSON = new File("src/main/resources/regular_users.json");
        List<RegularUser> regularUserJSON = jsonMapper.readValue(regularUsersFileJSON, jsonMapper.getTypeFactory()
                .constructCollectionType(List.class, RegularUser.class));

        //regular_users.yaml
        File regularUsersFileYAML = new File("src/main/resources/regular_users.yaml");
        List<RegularUser> regularUserYAML = yamlMapper.readValue(regularUsersFileYAML, yamlMapper.getTypeFactory()
                .constructCollectionType(List.class, RegularUser.class));

        Object[][] objData = new Object[1][4];
        objData[0][0]= adminUserJSON; //admin_users.json
        objData[0][1]= adminUserYAML; //admin_users.yaml
        objData[0][2]= regularUserJSON; //regular_users.json
        objData[0][3]= regularUserYAML; //regular_users.yaml

        return objData;
    }

    @Test(dataProvider = "dp")
    public void testMethod1(List<AdminUser> adminUserJSON, List<AdminUser> adminUserYAML,
                            List<RegularUser> regularUserJSON, List<RegularUser> regularUserYAML){
        System.out.println("-1-");
        Assert.assertEquals(adminUserJSON.get(0).getId(), 1);
        Assert.assertEquals(adminUserJSON.get(1).getName(), "Helen");
        System.out.println("-2-");
        Assert.assertEquals(adminUserYAML.get(0).getId(), 9);
        Assert.assertEquals(adminUserYAML.get(1).getName(), "Maya");
        System.out.println("-3-");
        Assert.assertEquals(regularUserJSON.get(0).getId(), 345);
        Assert.assertTrue(regularUserJSON.get(0).getAddress().getCity() != null);
        System.out.println("-4-");
        Assert.assertEquals(regularUserYAML.get(0).getId(), 345);
        Assert.assertEquals(regularUserYAML.get(1).getName(), "Oskar");
    }
}
/*@DataProvider(name = "dp")
    public Object[][] readListDetails() throws Exception {

        //mapper foe json files
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //mapper for yaml files
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
        yamlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //admin_users.json
        File adminUsersFileJSON = new File("src/main/resources/admin_users.json");
        List<AdminUser> adminUserJSON = jsonMapper.readValue(adminUsersFileJSON, jsonMapper.getTypeFactory()
                .constructCollectionType(List.class, AdminUser.class));

        //admin_users.yaml
        File adminUsersFileYAML = new File("src/main/resources/admin_users.yaml");
        List<AdminUser> adminUserYAML = yamlMapper.readValue(adminUsersFileYAML, yamlMapper.getTypeFactory()
                .constructCollectionType(List.class, AdminUser.class));

        //regular_users.json
        File regularUsersFileJSON = new File("src/main/resources/regular_users.json");
        List<RegularUser> regularUserJSON = jsonMapper.readValue(regularUsersFileJSON, jsonMapper.getTypeFactory()
                .constructCollectionType(List.class, RegularUser.class));

        //regular_users.yaml
        File regularUsersFileYAML = new File("src/main/resources/regular_users.yaml");
        List<RegularUser> regularUserYAML = yamlMapper.readValue(regularUsersFileYAML, yamlMapper.getTypeFactory()
                .constructCollectionType(List.class, RegularUser.class));

        Object[][] objData = new Object[1][4];
        objData[0][0]= adminUserJSON; //admin_users.json
        objData[0][1]= adminUserYAML; //admin_users.yaml
        objData[0][2]= regularUserJSON; //regular_users.json
        objData[0][3]= regularUserYAML; //regular_users.yaml

        return objData;
    }
        */