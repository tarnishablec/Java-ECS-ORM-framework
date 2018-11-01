package JDBCConf;

public class JDBCConfiguration {
    private String driver;
    private String url;
    private String user;
    private String pwd;
    private String usingDB;
    private String srcPath;
    private String poPath;

    public JDBCConfiguration(String driver, String url, String user, String pwd, String usingDB, String srcPath, String poPath) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.usingDB = usingDB;
        this.srcPath = srcPath;
        this.poPath = poPath;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getPoPath() {
        return poPath;
    }

    public void setPoPath(String poPath) {
        this.poPath = poPath;
    }
}
