package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //actual data sorgulamasinda asagidaki constructor da olmayan variable burada gormezden gelinecek
public class JsonPlaceHolderPojo {

    //1- private variable lar olusturun
   private Integer userId;
    private String title;
    private  Boolean completed ;

    //2- parametre siz constructor olustur
    public JsonPlaceHolderPojo() {
    }

    //2- parametreli constructor olustur
    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    //4- public getter ve setter methodlar olustur
    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    //4: toString() methodunu oluşturunuz

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
