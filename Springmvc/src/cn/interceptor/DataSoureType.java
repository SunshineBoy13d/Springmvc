package cn.interceptor;

public enum DataSoureType {
    Master("master"),
    Slave("slave");
    private  String name;
    private DataSoureType(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
