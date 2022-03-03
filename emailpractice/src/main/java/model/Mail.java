package model;

import java.util.Map;

public class Mail {
    private String to;
    private String from;
    private String subject;
    private String name;
    private String info;
    private String img;
    private Map<String,Object> props;
    public Mail() {
    }
    public Mail(String to, String from, String subject, Map<String, Object> props) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.props = props;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Map<String, Object> getProps() {
        return props;
    }
    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    
    
    
    
    
}
