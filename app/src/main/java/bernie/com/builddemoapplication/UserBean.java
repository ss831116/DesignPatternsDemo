package bernie.com.builddemoapplication;

/**
 * Created by bernie.shi on 2016/8/8.
 */

public class UserBean {
    public int age;
    public String name;
    public float bodyWeight;
    public float height;
    public int likeCount;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getBodyWeight() {
        return bodyWeight;
    }
    public void setBodyWeight(float bodyWeight) {
        this.bodyWeight = bodyWeight;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
    public static class Builder {
        UserBean userBean;
        public Builder() {
            this.userBean = new UserBean();
        }
        public Builder setName(String name) {
            this.userBean.setName(name);
            return this;
        }
        public Builder setAge(int age) {
            this.userBean.setAge(age);
            return this;
        }
        public Builder setBodyWeight(float bodyWeight) {
            this.userBean.setBodyWeight(bodyWeight);
            return this;
        }
        public Builder setHeight(float height) {
            this.userBean.setHeight(height);
            return this;
        }
        public UserBean build() {
            return this.userBean;
        }
    }
}
