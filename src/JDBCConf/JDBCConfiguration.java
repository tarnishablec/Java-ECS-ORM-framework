package JDBCConf;

public class JDBCConfiguration {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    private String usingDB;
    private String srcPath;
    private String componentPath;

    public JDBCConfiguration(String driver, String url, String user, String pwd, String usingDB, String srcPath, String componentPath) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.usingDB = usingDB;
        this.srcPath = srcPath;
        this.componentPath = componentPath;
    }

    public String getDriver() {
        return driver;
    }


    public String getUrl() {
        return url;
    }


    public String getUser() {
        return user;
    }


    public String getPwd() {
        return pwd;
    }


    public String getUsingDB() {
        return usingDB;
    }


    public String getSrcPath() {
        return srcPath;
    }


    public String getComponentPath() {
        return componentPath;
    }

}
