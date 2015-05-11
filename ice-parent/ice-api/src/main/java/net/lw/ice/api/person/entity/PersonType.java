package net.lw.ice.api.person.entity;


public enum PersonType {
    MANAGE(0,"银行人员"),
    FIXMAN(1, "维修人员"),
    ADMIN(2,"设备管机员"),
    MONITOR(3,"监督员"),
    LEADER(4,"法人总行管理员");

    private int id;
    private String text;

    private PersonType(int id ,String text){
        this.id = id;
        this.text= text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static PersonType getById(int id){
        for(PersonType each : PersonType.values()){
            if(each.getId() == id){
                return each;
            }
        }
        throw new IllegalArgumentException(String.format("id=[%d] error", id));
    }

}
