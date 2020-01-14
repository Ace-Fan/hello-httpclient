package com.wufan.hello.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Kirsh
 * @date 2020/1/14 10:23
 */
public class JsonTest {
    public static void main(String[] args) {
        //创建ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        //Json转Java对象
        String json = "{\"draw\": 1,\"recordsTotal\": 15,\"recordsFiltered\": 15,\"error\": null}";
        try {
            User user = objectMapper.readValue(json, User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class User {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
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

    @Override
    public String toString() {
        return "User{" +
                "draw=" + draw +
                ", recordsTotal=" + recordsTotal +
                ", recordsFiltered=" + recordsFiltered +
                ", error='" + error + '\'' +
                '}';
    }
}
