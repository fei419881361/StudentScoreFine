package gson;

public class AutoJson {
    private String account;
    private boolean status;
    private String name;
    private int type;

    public AutoJson() {
    }

    public AutoJson(String account, boolean status, String name, int type) {
        this.account = account;
        this.status = status;
        this.name = name;
        this.type = type;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int isType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
