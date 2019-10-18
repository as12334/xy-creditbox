package so.wwb.lotterybox.model.enums.common;

public enum TerminalEnum {
    ALL("0", "全部", "全部终端"),
    PC("1", "PC端", "PC"),
    M("2", "移动端", "Mobile");

    private String code;
    private String trans;
    private String name;

    TerminalEnum(String code, String trans, String name) {
        this.code = code;
        this.trans = trans;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getTrans() {
        return trans;
    }

    public String getName() {
        return name;
    }
}
