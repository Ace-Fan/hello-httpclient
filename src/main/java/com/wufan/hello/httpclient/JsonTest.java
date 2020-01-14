package com.wufan.hello.httpclient;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Kirsh
 * @date 2020/1/14 10:23
 */
public class JsonTest {
    public static void main(String[] args) {
        //PojoJson();

//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "{\"draw\":1,\"recordsTotal\":15,\"recordsFiltered\":15,\"data\":[{\"id\":7,\"created\":1428311035000,\"updated\":1428311035000,\"username\":\"zhangsan\",\"phone\":\"13488888888\",\"email\":\"aa@a\"},{\"id\":9,\"created\":1428373928000,\"updated\":1428373928000,\"username\":\"zhangsan1\",\"phone\":\"13333333333\",\"email\":null},{\"id\":10,\"created\":1428374017000,\"updated\":1428374017000,\"username\":\"zhangsan2\",\"phone\":\"13333333334\",\"email\":null},{\"id\":11,\"created\":1428374157000,\"updated\":1428374157000,\"username\":\"zhangsan3\",\"phone\":\"13333333335\",\"email\":null},{\"id\":12,\"created\":1428374779000,\"updated\":1428374779000,\"username\":\"zhangsan5\",\"phone\":\"13333333336\",\"email\":null},{\"id\":14,\"created\":1434679331000,\"updated\":1434679331000,\"username\":\"lisi\",\"phone\":\"12344444444\",\"email\":null},{\"id\":16,\"created\":1434680667000,\"updated\":1434680667000,\"username\":\"lisi1\",\"phone\":\"12344444442\",\"email\":null},{\"id\":17,\"created\":1434680746000,\"updated\":1434680746000,\"username\":\"jd_gogogo\",\"phone\":\"18800888888\",\"email\":null},{\"id\":18,\"created\":1438248385000,\"updated\":1438248385000,\"username\":\"tidy\",\"phone\":\"13600112243\",\"email\":null},{\"id\":22,\"created\":1438249713000,\"updated\":1438249713000,\"username\":\"tidy1\",\"phone\":\"13600112244\",\"email\":null}],\"error\":null}";
//        try {
//            User user = objectMapper.readValue(json, User.class);
//            System.out.println(user);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\"draw\":1,\"recordsTotal\":15,\"recordsFiltered\":15,\"data\":[{\"id\":7,\"created\":1428311035000,\"updated\":1428311035000,\"username\":\"zhangsan\",\"phone\":\"13488888888\",\"email\":\"aa@a\"},{\"id\":9,\"created\":1428373928000,\"updated\":1428373928000,\"username\":\"zhangsan1\",\"phone\":\"13333333333\",\"email\":null},{\"id\":10,\"created\":1428374017000,\"updated\":1428374017000,\"username\":\"zhangsan2\",\"phone\":\"13333333334\",\"email\":null},{\"id\":11,\"created\":1428374157000,\"updated\":1428374157000,\"username\":\"zhangsan3\",\"phone\":\"13333333335\",\"email\":null},{\"id\":12,\"created\":1428374779000,\"updated\":1428374779000,\"username\":\"zhangsan5\",\"phone\":\"13333333336\",\"email\":null},{\"id\":14,\"created\":1434679331000,\"updated\":1434679331000,\"username\":\"lisi\",\"phone\":\"12344444444\",\"email\":null},{\"id\":16,\"created\":1434680667000,\"updated\":1434680667000,\"username\":\"lisi1\",\"phone\":\"12344444442\",\"email\":null},{\"id\":17,\"created\":1434680746000,\"updated\":1434680746000,\"username\":\"jd_gogogo\",\"phone\":\"18800888888\",\"email\":null},{\"id\":18,\"created\":1438248385000,\"updated\":1438248385000,\"username\":\"tidy\",\"phone\":\"13600112243\",\"email\":null},{\"id\":22,\"created\":1438249713000,\"updated\":1438249713000,\"username\":\"tidy1\",\"phone\":\"13600112244\",\"email\":null}],\"error\":null}";

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            JsonNode data = jsonNode.findPath("data");
            System.out.println(data);
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, userData.class);
            List<userData> userDataList = objectMapper.readValue(data.toString(),javaType);
            for (userData userData : userDataList) {
                System.out.println(userData);
            }
            System.out.println(objectMapper.writeValueAsString(userDataList));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void PojoJson(){
        //创建ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Json转Java对象
        String json = "{\"draw\": 1,\"recordsTotal\": 15,\"recordsFiltered\": 15,\"error\": null}";
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println(user);
            String pojo2Json = objectMapper.writeValueAsString(user);
            System.out.println(pojo2Json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<userData> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<userData> getData() {
        return data;
    }

    public void setData(List<userData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", data=" + data +
                ", error='" + error + '\'' +
                '}';
    }
}

class userData {
    private Long id;
    private Date created;
    private Date updated;
    private String username;
    private String phone;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String  toString() {
        return "userData{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


