package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Reusable {
    public static RequestSpecification req;

    /* RequestSpecification has readymade methods to define base URL, base path, headers
    and query parameters */
    public RequestSpecification requestSpecification() throws IOException
    {
        try {
            if(req==null)
            {
                PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
                req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURL"))
                        .addQueryParam(getGlobalValue("keyParamterOne"), getGlobalValue("keyValyeOne"))
                        .addQueryParam(getGlobalValue("keyParameterTwo"), getGlobalValue("keyValueTwo"))
                        .addFilter(RequestLoggingFilter.logRequestTo(log))
                        .addFilter(ResponseLoggingFilter.logResponseTo(log))
                        .setUrlEncodingEnabled(false)
                        .setContentType(ContentType.JSON).build();
                return req;
            }
            return req;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*ResponseSpecification has readymade methods to define assertions like status code
    and content type */
    public ResponseSpecification responseSpecification(){
        try {
            ResponseSpecification res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* Method to fetch the configuration parameters from global properties file*/
    public static String getGlobalValue(String key) throws IOException
    {
        try {
            Properties prop = new Properties();
            InputStream fis = Reusable.class.getClassLoader().getResourceAsStream("global.properties");
            prop.load(fis);
            return prop.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

